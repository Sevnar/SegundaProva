package com.example.segundaprova

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetalhesFragmentViewModelFactory(val application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetalhesFragmentViewModel::class.java)){
            return DetalhesFragmentViewModel(application) as T
        }
        throw IllegalArgumentException("Deu Ruim")
    }
}