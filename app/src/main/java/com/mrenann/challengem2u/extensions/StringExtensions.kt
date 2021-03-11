package com.mrenann.challengem2u.extensions

import com.mrenann.challengem2u.utils.Constants.Api.BASE_URL_ORIGINAL_IMAGE

fun String.getFullImagePath(): String {
    return "${BASE_URL_ORIGINAL_IMAGE}${this}"
}
