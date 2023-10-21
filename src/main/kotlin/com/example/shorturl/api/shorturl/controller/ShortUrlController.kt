package com.example.shorturl.api.shorturl.controller

import com.example.shorturl.api.shorturl.model.ShortUrlSaveReq
import com.example.shorturl.api.shorturl.service.ShortUrlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ShortUrlController(private val shortUrlService: ShortUrlService) {

    @GetMapping("/short-url/{seq}")
    fun getShortUrlBySeq(@PathVariable("seq") seq: Long): ResponseEntity<Any> {
        shortUrlService.getShortUrl(seq)
        return ResponseEntity.ok().body("success");
    }

    @PostMapping("/short-url")
    fun addShortUrl(@RequestBody saveReq: ShortUrlSaveReq): ResponseEntity<Any> {
        shortUrlService.addShortUrl(saveReq)
        return ResponseEntity.ok().body("success");
    }
}