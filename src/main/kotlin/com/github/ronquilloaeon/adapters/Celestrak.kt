package com.github.ronquilloaeon.adapters

import io.github.rybalkinsd.kohttp.ext.asString
import io.github.rybalkinsd.kohttp.ext.httpGet

const val SOURCE_URL_TEMPLATE = "https://celestrak.com/NORAD/elements/%s.txt"

/*
 * Fetch TLE lines from celestrak
 * Uses [category] to fetch TLE text file (e.g. "starlink" in "https://celestrak.com/NORAD/elements/starlink.txt")
 * @return TLE lines
 */
fun getTLEs(category: String) : List<String> {
    val response = SOURCE_URL_TEMPLATE.format(category).httpGet()
    val body = response.asString() ?: ""
    return body.lines()
}
