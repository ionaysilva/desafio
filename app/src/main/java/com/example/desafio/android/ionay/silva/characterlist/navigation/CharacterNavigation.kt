package com.example.desafio.android.ionay.silva.characterlist.navigation

import Results
import android.content.Context

interface CharacterNavigation {
    fun openComicCharacter(context: Context, id: Int)
    fun openDetailCharacter(context: Context, result: Results)
}