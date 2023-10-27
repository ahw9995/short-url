package com.example.shorturl.api.shorturl.util

import com.example.shorturl.api.shorturl.exception.Base62DecodeErrorException
import com.example.shorturl.api.shorturl.exception.Base62EncodeErrorException
import com.example.shorturl.api.shorturl.exception.common.ErrorMessageType
import mu.KotlinLogging

class Base62 {

    companion object {

        private val log = KotlinLogging.logger {}
        private const val defaultString =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

        fun encode(code: Long): String {

            try {
                if (code < 0) {
                    throw IllegalArgumentException("code must be non negative")
                }

                var b10 = code
                var result = ""
                while (b10 > 0) {
                    result = defaultString[((b10 % 62).toInt())] + result
                    b10 /= 62
                }

                return result
            } catch (e: Exception) {
                log.error(e) { e }
                throw Base62EncodeErrorException(ErrorMessageType.BASE62_ENCODE_ERROR_EXCEPTION)
            }
        }

        fun decode(code: String): Long {
            return decodeProcess(code)
        }

        private fun decodeProcess(code: String): Long {

            try {
                var result: Long = 0
                val b62 = StringBuffer(code).reverse().toString()
                var count: Long = 1

                for (character in b62.toCharArray()) {
                    result += defaultString.indexOf(character) * count
                    count *= 62
                }

                return result
            } catch (e: Exception) {
                log.error(e) { e }
                throw Base62DecodeErrorException(ErrorMessageType.BASE62_DECODE_ERROR_EXCEPTION)
            }
        }
    }
}