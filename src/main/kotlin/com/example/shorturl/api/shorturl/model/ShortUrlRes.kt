package com.example.shorturl.api.shorturl.model

import jakarta.servlet.http.HttpServletRequest

data class ShortUrlRes(
    val shortUrl: String
) {
    constructor(id: String?, request: HttpServletRequest): this(
        shortUrl = "${request.scheme}://${request.serverName}:${request.serverPort}/${id}"
    )
}