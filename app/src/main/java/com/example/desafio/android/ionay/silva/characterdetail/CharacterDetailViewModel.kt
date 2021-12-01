package com.example.desafio.android.ionay.silva.characterdetail

import android.content.Context
import com.example.desafio.android.ionay.silva.base.BaseViewModel
import com.example.desafio.android.ionay.silva.characterlist.navigation.CharacterNavigation

class CharacterDetailViewModel(private val  characterNavigation: CharacterNavigation) : BaseViewModel() {

    fun openComicActivity(context: Context, id: Int) {
        characterNavigation.openComicCharacter(context, id)
    }

}