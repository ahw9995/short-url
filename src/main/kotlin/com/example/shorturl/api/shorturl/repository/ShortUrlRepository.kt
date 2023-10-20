package com.example.shorturl.api.shorturl.repository

import com.example.shorturl.api.shorturl.entity.ShortUrl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShortUrlRepository: JpaRepository<ShortUrl, Long> {
}