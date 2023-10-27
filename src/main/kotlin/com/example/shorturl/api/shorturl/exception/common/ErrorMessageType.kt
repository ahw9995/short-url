package com.example.shorturl.api.shorturl.exception.common

enum class ErrorMessageType(val code: String, val message: String) {

    // base62 error
    BASE62_DECODE_ERROR_EXCEPTION("00", "BASE62 복호화 중 오류가 발생했습니다."),
    BASE62_ENCODE_ERROR_EXCEPTION("01", "BASE62 암호화 중 오류가 발생했습니다."),


    CREATE_SHORT_URL_FAILED_EXCEPTION("90", "단축 URL 생성에 실패했습니다."),
    CREATE_ID_FAILED_EXCEPTION("91", "단축 URL ID 생성에 실패했습니다."),
    ID_NOT_FOUND_EXCEPTION("99", "존재하지 않는 단축 URL 입니다.")

}