package com.example.shorturl.api.shorturl.exception.common

import com.example.shorturl.api.common.model.ResponseObject
import com.example.shorturl.api.common.model.ResultObject
import com.example.shorturl.api.shorturl.exception.Base62DecodeErrorException
import com.example.shorturl.api.shorturl.exception.Base62EncodeErrorException
import com.example.shorturl.api.shorturl.exception.CreateShortUrlFailedException
import com.example.shorturl.api.shorturl.exception.IDNotFoundException
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalControllerAdvice {

    private val log = KotlinLogging.logger {}

    @ExceptionHandler(CreateShortUrlFailedException::class)
    fun shortUrlCreateFailedExceptionHandler(e: CreateShortUrlFailedException): ResponseEntity<ResponseObject<Any>> {
        log.error(e) { e }

        return ResponseEntity.internalServerError()
            .body(ResponseObject(ResultObject(ErrorMessageType.CREATE_SHORT_URL_FAILED_EXCEPTION)))
    }

    @ExceptionHandler(IDNotFoundException::class)
    fun idNotFoundExceptionHandler(e: IDNotFoundException): ResponseEntity<ResponseObject<Any>> {
        log.error(e) { e }

        return ResponseEntity.internalServerError()
            .body(ResponseObject(ResultObject(ErrorMessageType.ID_NOT_FOUND_EXCEPTION)))
    }

    @ExceptionHandler(Base62EncodeErrorException::class)
    fun base62EncodeErrorExceptionHandler(e: Base62EncodeErrorException): ResponseEntity<ResponseObject<Any>> {
        log.error(e) { e }

        return ResponseEntity.internalServerError()
            .body(ResponseObject(ResultObject(ErrorMessageType.BASE62_ENCODE_ERROR_EXCEPTION)))
    }

    @ExceptionHandler(Base62DecodeErrorException::class)
    fun base62DecodeErrorExceptionHandler(e: Base62DecodeErrorException): ResponseEntity<ResponseObject<Any>> {
        log.error(e) { e }

        return ResponseEntity.internalServerError()
            .body(ResponseObject(ResultObject(ErrorMessageType.BASE62_DECODE_ERROR_EXCEPTION)))
    }

}