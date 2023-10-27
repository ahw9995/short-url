package com.example.shorturl.api.shorturl.exception

import com.example.shorturl.api.shorturl.exception.common.ErrorMessageType

data class CreateShortUrlFailedException(override val message: String, val errorCode: String) :
    RuntimeException(message) {
    constructor(type: ErrorMessageType) : this(
        type.code,
        type.message
    )
}