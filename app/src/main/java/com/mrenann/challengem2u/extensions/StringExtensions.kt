package com.mrenann.challengem2u.extensions

import com.mrenann.challengem2u.utils.Constants.Api.BASE_URL_ORIGINAL_IMAGE
import java.text.DecimalFormat

fun String.getFullImagePath(): String {
    return "${BASE_URL_ORIGINAL_IMAGE}${this}"
}
fun String.getFirst4Chars():String{
    return "${this[0]}${this[1]}${this[2]}${this[3]}"
}

fun prettyCount(number: Int): String? {
    val suffix = charArrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
    val numValue = number.toLong()
    val value = Math.floor(Math.log10(numValue.toDouble())).toInt()
    val base = value / 3
    return if (value >= 3 && base < suffix.size) {
        DecimalFormat("#0.0").format(
            numValue / Math.pow(
                10.0,
                (base * 3).toDouble()
            )
        ) + suffix[base]
    } else {
        DecimalFormat("#,##0").format(numValue)
    }
}