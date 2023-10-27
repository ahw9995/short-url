package com.example.shorturl.api.shorturl.controller

import com.example.shorturl.api.common.model.ResponseObject
import com.example.shorturl.api.shorturl.model.ShortUrlSaveReq
import com.example.shorturl.api.shorturl.service.ShortUrlService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
class ShortUrlController(private val shortUrlService: ShortUrlService) {

    @GetMapping("/{id}")
    fun getShortUrlBySeq(@PathVariable("id") id: String): ResponseEntity<Any> {
        // redirect 해야 함
        return shortUrlService.getRedirectResponseEntity(id)
    }

    @PostMapping("/short-url")
    fun addShortUrl(@RequestBody saveReq: ShortUrlSaveReq): ResponseEntity<ResponseObject<Any>> {
        return ResponseEntity.ok().body(ResponseObject(shortUrlService.addShortUrl(saveReq)));
    }
}