package com.example.shorturl.api.shorturl.controller

import com.example.shorturl.api.shorturl.service.ShortUrlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ShortUrlController(private val shortUrlService: ShortUrlService) {

    @GetMapping("/short-url/{seq}")
    fun getShortUrlBySeq(@PathVariable("seq") seq: Long): ResponseEntity<Any> {
        shortUrlService.getShortUrl(seq)
        shortUrlService.addShortUrl("https://naver.com")
        return ResponseEntity.ok().body("success");
    }

    @PostMapping("/short-url")
    fun addShortUrl(): ResponseEntity<Any> {
        shortUrlService.addShortUrl("https://naver.com")
        return ResponseEntity.ok().body("success");
    }
}