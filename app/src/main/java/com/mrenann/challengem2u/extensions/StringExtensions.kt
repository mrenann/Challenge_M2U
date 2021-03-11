package com.mrenann.challengem2u.extensions

import com.mrenann.challengem2u.utils.Constants.Api.BASE_URL_ORIGINAL_IMAGE

fun String.getFullImagePath(): String {
    return "${BASE_URL_ORIGINAL_IMAGE}${this}"
}
fun String.getFirst4Chars():String{
    return "${this[0]}${this[1]}${this[2]}${this[3]}"
}