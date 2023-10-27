package com.example.shorturl.api.shorturl.model

import com.example.shorturl.api.shorturl.entity.ShortUrl

data class ShortUrlRes(
    val seq: Long?,
    val id: String?,
    val longUrl: String
) {
    companion object {
        fun fromEntity(shortUrl: ShortUrl): ShortUrlRes {
            return ShortUrlRes(shortUrl.seq, shortUrl.id, shortUrl.longUrl)
        }
    }
}