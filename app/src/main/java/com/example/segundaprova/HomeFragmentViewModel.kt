package com.example.segundaprova

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room

class HomeFragmentViewModel(application: Application): AndroidViewModel(application) {
    private var _igrejas = MutableLiveData<List<Igreja>>()
    var igrejas:LiveData<List<Igreja>> = _igrejas

    init {
        val db:IgrejaDatabase by lazy {
            Room.databaseBuilder(application.applicationContext, IgrejaDatabase::class.java, "Igrejas.sqlite")
                .allowMainThreadQueries()
                .build()
        }
        _igrejas.value = db.IgrejaDao().listAll()
    }

}