package com.example.desafio.android.ionay.silva.di.modules

import com.example.desafio.android.ionay.silva.characterdetail.CharacterDetailViewModel
import com.example.desafio.android.ionay.silva.characterlist.CharacterListViewModel
import com.example.desafio.android.ionay.silva.comic.ComicCharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { CharacterListViewModel(get(), get()) }
    viewModel { ComicCharacterViewModel(get()) }
    viewModel { CharacterDetailViewModel(get()) }
}