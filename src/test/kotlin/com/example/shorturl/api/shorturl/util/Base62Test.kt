package com.example.shorturl.api.shorturl.util

import org.junit.jupiter.api.Test

class Base62Test {

    @Test
    fun encode() {

        val baseCode: Long = 38098

        val encode = Base62.encode(baseCode)

        val decode = Base62.decode(encode)

        assert(baseCode == decode)
    }
}