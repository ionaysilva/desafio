package com.example.desafio.android.ionay.silva.di.modules

import com.example.desafio.android.ionay.silva.network.config.Config
import org.koin.dsl.module

val networkModule = module {

    single { Config.provideGson() }
    single { Config.provideAuthInterceptor() }
    single { Config.provideHttpClient(get()) }
    single { Config.provideRetrofit(get(), get()) }

}