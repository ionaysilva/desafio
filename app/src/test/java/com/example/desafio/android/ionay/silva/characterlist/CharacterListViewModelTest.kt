package com.example.desafio.android.ionay.silva.characterlist

import Results
import Thumbnail
import android.app.Application
import com.example.desafio.android.ionay.silva.characterlist.navigation.CharacterNavigation
import com.example.desafio.android.ionay.silva.repository.MarvelRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class CharacterListViewModelTest {

    private val characterNavigation: CharacterNavigation = mockk(relaxed = true)
    private val marvelRepository: MarvelRepository = mockk(relaxed = true)

    private val context: Application = mockk(relaxed = true)

    private lateinit var characterListViewModel: CharacterListViewModel

    @Before
    fun setup() {
        characterListViewModel = CharacterListViewModel(marvelRepository, characterNavigation)
    }

    @Test
    fun whenOpenDetailCharacter_shouldNavigationOpenDetailCharacterCalled() {
        characterListViewModel.openDetailCharacter(
            context,
            Results(2012, "teste", "descrição", Thumbnail("path", "extension"), "resourceURI")
        )
        verify { characterNavigation.openDetailCharacter(any(), any()) }
    }

}