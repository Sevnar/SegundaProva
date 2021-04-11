package com.example.segundaprova

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CadastraFragmentViewModelFactory(val application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)){
            return CadastraFragmentViewModel(application) as T
        }
        throw IllegalArgumentException("Deu Ruim")
    }
}