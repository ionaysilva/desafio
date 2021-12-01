package com.example.desafio.android.ionay.silva.di.modules

import com.example.desafio.android.ionay.silva.characterlist.navigation.CharacterNavigation
import com.example.desafio.android.ionay.silva.characterlist.navigation.CharacterNavigationImpl
import com.example.desafio.android.ionay.silva.repository.MarvelRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {

    factory { MarvelRepository(get()) }
    factory { CharacterNavigationImpl() } bind CharacterNavigation::class

}