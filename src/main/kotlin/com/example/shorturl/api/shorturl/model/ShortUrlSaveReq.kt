package com.example.shorturl.api.shorturl.model

import com.example.shorturl.api.shorturl.entity.ShortUrl
import jakarta.validation.constraints.NotBlank

data class ShortUrlSaveReq(
    @field:NotBlank(message = "단축할 URL 정보는 필수값 입니다.")
    val longUrl: String
) {
    fun toEntity(): ShortUrl {
        return ShortUrl(null, "", longUrl, null)
    }
}