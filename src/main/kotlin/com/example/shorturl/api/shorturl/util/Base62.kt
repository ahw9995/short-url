package com.example.shorturl.api.shorturl.util

class Base62 {

    companion object {

        private const val defaultString = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        fun encode(code: Long): String {

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
        }

        fun decode(code: String): Long {
            return decodeProcess(code)
        }

        private fun decodeProcess(code: String): Long {

            var result: Long = 0
            val b62 = StringBuffer(code).reverse().toString()
            var count: Long = 1

            for (character in b62.toCharArray()) {
                result += defaultString.indexOf(character) * count
                count *= 62
            }

            return result
        }
    }
}