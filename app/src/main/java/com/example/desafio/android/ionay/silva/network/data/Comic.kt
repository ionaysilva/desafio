package com.example.desafio.android.ionay.silva.network.data

import Thumbnail

data class Comic (
    val id: Int,
    val title: String,
    val description: String,
    val prices: List<Price>,
    val thumbnail: Thumbnail)