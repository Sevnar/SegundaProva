package com.example.segundaprova

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room

@Suppress("DEPRECATION")
class HomeFragmentViewModel(application: Application): AndroidViewModel(application) {
    private var _igrejas = MutableLiveData<List<Igreja>>()
    var igrejas:LiveData<List<Igreja>> = _igrejas

    init {
        val db:IgrejaDatabase by lazy {
            Room.databaseBuilder(application.applicationContext, IgrejaDatabase::class.java, "Igrejas.sqlite")
                .build()
        }

        _igrejas.value = ListAllTask(db).execute().get()
    }

    private inner class ListAllTask(var db:IgrejaDatabase): AsyncTask<Igreja, Int, List<Igreja>>(){
        override fun doInBackground(vararg params: Igreja?): List<Igreja> {
            return db.IgrejaDao().listAll()
        }
    }
}

