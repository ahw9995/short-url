package com.example.shorturl.api.common.model

import com.example.shorturl.api.shorturl.exception.common.ErrorMessageType

data class ResultObject(var code: String, var message: String) {
    constructor(type: ErrorMessageType) : this(
        type.code,
        type.message
    )
}