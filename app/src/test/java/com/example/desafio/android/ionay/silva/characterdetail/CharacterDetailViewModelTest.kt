package com.example.desafio.android.ionay.silva.characterdetail

import android.app.Application
import com.example.desafio.android.ionay.silva.characterlist.navigation.CharacterNavigation
import com.example.desafio.android.ionay.silva.repository.MarvelRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class CharacterDetailViewModelTest {

    private val characterNavigation: CharacterNavigation = mockk(relaxed = true)

    private val context: Application = mockk(relaxed = true)

    private lateinit var characterDetailViewModel: CharacterDetailViewModel

    @Before
    fun setup() {
        characterDetailViewModel = CharacterDetailViewModel(characterNavigation)
    }

    @Test
    fun whenOpenDetailCharacter_shouldNavigationOpenDetailCharacterCalled() {
        characterDetailViewModel.openComicActivity(context, 1)
        verify { characterNavigation.openComicCharacter(any(), any()) }
    }
}