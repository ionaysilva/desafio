package com.example.desafio.android.ionay.silva.network.interceptor

import com.example.desafio.android.ionay.silva.util.md5
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    val API_KEY = "0bfd39a310a9e4e950ee63e6d8fdee7a"
    val PRIVATE_KEY = "40657afa657452fa2a76efe41dc12a69806d7647"

    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val ts = "1"
        val hash = "$ts${PRIVATE_KEY}${API_KEY}".md5()
        val url = req.url.newBuilder()
            .addQueryParameter("ts", ts)
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("hash", hash)
            .build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }

}