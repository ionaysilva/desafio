package com.example.desafio.android.ionay.silva.network.config

import com.example.desafio.android.ionay.silva.network.MarvelApi
import com.example.desafio.android.ionay.silva.network.interceptor.AuthInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Config {
    const val BASE_URL = "https://gateway.marvel.com"

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideAuthInterceptor() : Interceptor {
        return AuthInterceptor()
    }

    fun provideHttpClient(interceptor: Interceptor): OkHttpClient {
        val interceptorHeaders = HttpLoggingInterceptor()
        interceptorHeaders.level = HttpLoggingInterceptor.Level.HEADERS

        val interceptorBody = HttpLoggingInterceptor()
        interceptorHeaders.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(interceptorHeaders)
        okHttpClientBuilder.addInterceptor(interceptorBody)
        okHttpClientBuilder.addInterceptor(interceptor)
        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): MarvelApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
            .create(MarvelApi::class.java)
    }


}