package com.example.shorturl.api.shorturl.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "short_url")
data class ShortUrl(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val seq: Long?,
    @Column
    val id: String,
    @Column
    val longUrl: String,
    @Column
    val createdAt: LocalDateTime?
)