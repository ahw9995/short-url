package com.example.shorturl.api.shorturl.controller

import com.example.shorturl.api.common.model.ResponseObject
import com.example.shorturl.api.shorturl.model.ShortUrlSaveReq
import com.example.shorturl.api.shorturl.service.ShortUrlService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ShortUrlController(private val shortUrlService: ShortUrlService) {

    @GetMapping("/{id}")
    fun getShortUrl(@PathVariable("id") id: String): ResponseEntity<Any> {
        return shortUrlService.getRedirectResponseEntity(id)
    }

    @PostMapping("/short-url")
    fun addShortUrl(
        @RequestBody saveReq: ShortUrlSaveReq,
        request: HttpServletRequest
    ): ResponseEntity<ResponseObject<Any>> {
        return ResponseEntity.ok()
            .body(ResponseObject(shortUrlService.addShortUrl(saveReq, request)));
    }
}