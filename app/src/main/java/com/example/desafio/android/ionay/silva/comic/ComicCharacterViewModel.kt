package com.example.desafio.android.ionay.silva.comic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.desafio.android.ionay.silva.base.BaseViewModel
import com.example.desafio.android.ionay.silva.network.data.Comic
import com.example.desafio.android.ionay.silva.repository.MarvelRepository
import kotlinx.coroutines.launch

class ComicCharacterViewModel(private val marvelRepository: MarvelRepository) : BaseViewModel() {

    val mComicCharactersData: MutableLiveData<Comic> = MutableLiveData()

    fun getComicsCharacter(id: Int) {
        loadingLiveData.value = true
        viewModelScope.launch {
            try {
                val comicsCharacter = marvelRepository.getComicsCharacter(id)
                val maxByOrNull =
                    comicsCharacter.data.results.maxByOrNull { comic -> comic.prices.get(0).price }
                if (maxByOrNull != null) {
                    mComicCharactersData.value = maxByOrNull
                } else {
                    errorLiveData.value = true
                }
            } catch (e: Exception) {
                errorLiveData.value = true
            }

        }

    }
}