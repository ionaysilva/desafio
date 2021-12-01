package com.example.desafio.android.ionay.silva.network

import ComicsCharactersData
import com.example.desafio.android.ionay.silva.network.data.CharacterResponse
import com.example.desafio.android.ionay.silva.network.data.ComicCharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelApi {

    @GET("/v1/public/characters?limit=20")
    suspend fun getCharacters(): CharacterResponse

    @GET("/v1/public/characters/{characterId}/comics")
    suspend fun getComicsCharacter(@Path("characterId") characterId: Int): ComicCharacterResponse

}