package com.example.desafio.android.ionay.silva.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafio.android.ionay.silva.network.data.Comic

open class BaseViewModel() : ViewModel() {

    protected val _loadingLiveData = MutableLiveData<Boolean>()
    val loadingLiveData: LiveData<Boolean> get() = _loadingLiveData
    protected val _errorLiveData = MutableLiveData<Boolean>()
    val errorLiveData: LiveData<Boolean> get() = _errorLiveData
}