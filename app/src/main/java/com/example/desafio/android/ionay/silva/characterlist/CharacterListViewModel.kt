package com.example.desafio.android.ionay.silva.characterlist

import Results
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.desafio.android.ionay.silva.base.BaseViewModel
import com.example.desafio.android.ionay.silva.characterlist.navigation.CharacterNavigation
import com.example.desafio.android.ionay.silva.network.data.CharacterResponse
import com.example.desafio.android.ionay.silva.repository.MarvelRepository
import kotlinx.coroutines.launch

class CharacterListViewModel(private val marvelRepository: MarvelRepository, private val characterNavigation: CharacterNavigation) : BaseViewModel() {

    val mCharactersData: MutableLiveData<CharacterResponse> = MutableLiveData()

    fun getCharacters() {
        loadingLiveData.value = true
        viewModelScope.launch {
            try {
                mCharactersData.value = marvelRepository.getCharacters()
            } catch (e: Exception) {
                errorLiveData.value = true
            }
        }
    }

    fun openDetailCharacter(context: Context, result: Results) {
        characterNavigation.openDetailCharacter(context, result)
    }

}