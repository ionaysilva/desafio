package com.example.desafio.android.ionay.silva.network.data

import ComicsCharactersData

data class ComicCharacterResponse(
    val code: Int,
    val etag: String,
    val data: ComicsCharactersData
)
