package com.example.desafio.android.ionay.silva.application

import android.app.Application
import com.example.desafio.android.ionay.silva.di.addModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(addModules)
        }
    }
}