package com.example.shorturl.api.shorturl.service

import com.example.shorturl.api.shorturl.entity.ShortUrl
import com.example.shorturl.api.shorturl.model.ShortUrlRes
import com.example.shorturl.api.shorturl.model.ShortUrlSaveReq
import com.example.shorturl.api.shorturl.repository.ShortUrlRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ShortUrlService(private val shortUrlRepository: ShortUrlRepository) {

    fun getShortUrl(seq: Long): ShortUrl? = shortUrlRepository.findBySeq(seq)

    @Transactional
    fun addShortUrl(saveReq: ShortUrlSaveReq): ShortUrlRes {

        // db에 같은 url 존재하는지 체크
        val checkUrl: ShortUrl? = shortUrlRepository.findByLongUrl(saveReq.longUrl)

        if (checkUrl != null) {
            return ShortUrlRes.fromEntity(checkUrl)
        }

        // 없으면 저장
        val shortUrl = saveReq.toEntity()
        shortUrlRepository.save(shortUrl)

        // base 62 암호화

        // 정보 업데이트


        return ShortUrlRes.fromEntity(shortUrl)
    }
}