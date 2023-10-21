package com.example.shorturl.api.shorturl.repository

import com.example.shorturl.api.shorturl.entity.ShortUrl

interface ShortUrlRepositoryCustom {

    fun findBySeq(seq: Long): ShortUrl?

    fun findByLongUrl(longUrl: String): ShortUrl?
}