package com.example.desafio.android.ionay.silva.characterdetail

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.desafio.android.ionay.silva.R

class CharacterDetailActivityRobot( block: CharacterDetailActivityRobot.() -> Unit) {

    init {
        block.invoke(this)
    }
//TODO: aplicar teste de interface
//    fun clickImageListItem(){
//        onView(
//            withId(R.id.character_image)
//        )
//    }
}