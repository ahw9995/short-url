package com.example.shorturl.api.shorturl.service

import com.example.shorturl.api.shorturl.entity.ShortUrl
import com.example.shorturl.api.shorturl.exception.CreateShortUrlFailedException
import com.example.shorturl.api.shorturl.exception.IDNotFoundException
import com.example.shorturl.api.shorturl.exception.common.ErrorMessageType
import com.example.shorturl.api.shorturl.model.ShortUrlRes
import com.example.shorturl.api.shorturl.model.ShortUrlSaveReq
import com.example.shorturl.api.shorturl.repository.ShortUrlRepository
import com.example.shorturl.api.shorturl.util.Base62
import jakarta.servlet.http.HttpServletRequest
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.StringUtils
import java.net.URI

@Service
@Transactional(readOnly = true)
class ShortUrlService(private val shortUrlRepository: ShortUrlRepository) {

    @Cacheable(value = ["shortUrlCache"], key = "#id")
    fun getRedirectResponseEntity(id: String): ResponseEntity<Any> {
        val longUrl = this.getShortUrl(id)
        val headers = HttpHeaders()
        headers.contentType = MediaType.TEXT_HTML
        headers.set("referrer-policy", "unsafe-url")
        headers.location = URI.create(longUrl)

        return ResponseEntity(headers, HttpStatus.MOVED_PERMANENTLY)
    }

    fun getShortUrl(id: String): String? {

        // 복호화
        val seq = Base62.decode(id)

        val shortUrl = shortUrlRepository.findBySeq(seq)
            ?: throw IDNotFoundException(ErrorMessageType.ID_NOT_FOUND_EXCEPTION)

        return shortUrl.longUrl
    }

    @Transactional
    fun addShortUrl(saveReq: ShortUrlSaveReq, request: HttpServletRequest): ShortUrlRes {

        // db에 같은 url 존재하는지 체크
        val checkUrl: ShortUrl? = shortUrlRepository.findByLongUrl(saveReq.longUrl)

        if (checkUrl != null) {
            return ShortUrlRes(checkUrl.id, request)
        }

        // 없으면 저장
        val shortUrl = saveReq.toEntity()
        shortUrlRepository.save(shortUrl)

        // base 62 암호화
        if (shortUrl.seq == null) {
            throw CreateShortUrlFailedException(ErrorMessageType.CREATE_SHORT_URL_FAILED_EXCEPTION)
        }

        val id = Base62.encode(shortUrl.seq!!)

        if (!StringUtils.hasText(id)) {
            throw CreateShortUrlFailedException(ErrorMessageType.CREATE_ID_FAILED_EXCEPTION)
        }

        // 정보 업데이트
        shortUrl.id = id
        shortUrlRepository.updateIdBySeq(shortUrl)
        return ShortUrlRes(id, request)
    }
}