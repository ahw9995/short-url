package com.example.shorturl.api.shorturl.repository

import com.example.shorturl.api.shorturl.entity.ShortUrl

interface ShortUrlRepositoryCustom {

    fun findBySeq(seq: Long): ShortUrl?

    fun findById(id: String): ShortUrl?

    fun findByLongUrl(longUrl: String): ShortUrl?

    fun updateIdBySeq(shortUrl: ShortUrl)
}