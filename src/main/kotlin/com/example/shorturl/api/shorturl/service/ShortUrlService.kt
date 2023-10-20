package com.example.shorturl.api.shorturl.service

import com.example.shorturl.api.shorturl.entity.ShortUrl
import com.example.shorturl.api.shorturl.repository.ShortUrlRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ShortUrlService(private val shortUrlRepository: ShortUrlRepository) {

    fun getShortUrl(seq: Long): ShortUrl = shortUrlRepository.findById(seq).get()

    @Transactional
    fun addShortUrl(url: String) {
        shortUrlRepository.save(ShortUrl(seq = null, id = "", longUrl = url, createdAt = null))
    }
}