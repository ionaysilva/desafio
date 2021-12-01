package com.example.desafio.android.ionay.silva.di

import com.example.desafio.android.ionay.silva.di.modules.networkModule
import com.example.desafio.android.ionay.silva.di.modules.repositoryModule
import com.example.desafio.android.ionay.silva.di.modules.viewModelModule

val addModules = listOf(
    networkModule,
    viewModelModule,
    repositoryModule
)