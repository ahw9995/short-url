package com.example.shorturl.api.shorturl.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "short_url")
class ShortUrl(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val seq: Long?,
    @Column(nullable = true)
    var id: String = "",
    @Column(name = "long_url", nullable = false)
    var longUrl: String = "",
    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
)