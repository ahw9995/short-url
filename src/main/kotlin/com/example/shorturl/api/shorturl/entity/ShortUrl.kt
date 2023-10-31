package com.example.shorturl.api.shorturl.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "short_url")
data class ShortUrl(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val seq: Long?,
    @Column(nullable = true)
    var id: String?,
    @Column(name = "long_url", nullable = false)
    val longUrl: String,
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime?
)