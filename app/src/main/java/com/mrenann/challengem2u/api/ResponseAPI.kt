package com.mrenann.challengem2u.api

sealed class ResponseAPI {
    class Success(val data: Any?): ResponseAPI()
    class Error (val message: String): ResponseAPI()
}