package com.example.desafio.android.ionay.silva.characterlist.navigation

import Results
import android.content.Context
import android.content.Intent
import com.example.desafio.android.ionay.silva.characterdetail.CharacterDetailActivity
import com.example.desafio.android.ionay.silva.comic.ComicCharacterActivity

class CharacterNavigationImpl: CharacterNavigation {

    enum class Extras{
        CHARACTER,
        CHARACTER_ID

    }

    override fun openComicCharacter(context: Context, id: Int) {
        val intent = Intent(context, ComicCharacterActivity::class.java)
        intent.putExtra(Extras.CHARACTER_ID.name, id)
        context.startActivity(intent)
    }

    override fun openDetailCharacter(context: Context, result: Results) {
        val intent = Intent(context, CharacterDetailActivity::class.java)
        intent.putExtra(Extras.CHARACTER.name, result)
        context.startActivity(intent)
    }
}