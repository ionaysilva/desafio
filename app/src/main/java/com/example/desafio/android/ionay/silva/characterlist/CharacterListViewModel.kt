package com.example.desafio.android.ionay.silva.characterlist

import Results
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.desafio.android.ionay.silva.base.BaseViewModel
import com.example.desafio.android.ionay.silva.characterlist.navigation.CharacterNavigation
import com.example.desafio.android.ionay.silva.network.data.CharacterResponse
import com.example.desafio.android.ionay.silva.repository.MarvelRepository
import kotlinx.coroutines.launch

class CharacterListViewModel(private val marvelRepository: MarvelRepository, private val characterNavigation: CharacterNavigation) : BaseViewModel() {

    private val _charactersData: MutableLiveData<CharacterResponse> = MutableLiveData()
    val mCharactersData: LiveData<CharacterResponse> get() = _charactersData

    fun getCharacters() {
        _loadingLiveData.value = true
        viewModelScope.launch {
            try {
                _charactersData.value = marvelRepository.getCharacters()
            } catch (e: Exception) {
                _errorLiveData.value = true
            }
        }
    }

    fun openDetailCharacter(context: Context, result: Results) {
        characterNavigation.openDetailCharacter(context, result)
    }

}