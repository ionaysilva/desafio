package com.example.desafio.android.ionay.silva.repository

import com.example.desafio.android.ionay.silva.network.MarvelApi

class MarvelRepository(
    private val marvelApi: MarvelApi
) {

    suspend fun getCharacters() = marvelApi.getCharacters()


    suspend fun getComicsCharacter(characterId: Int) = marvelApi.getComicsCharacter(characterId)

}

