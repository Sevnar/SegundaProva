package com.example.segundaprova

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room

@Suppress("DEPRECATION")
class DetalhesFragmentViewModel(application: Application): AndroidViewModel(application) {

    var banco: IgrejaDatabase
    lateinit var igreja: Igreja

    init {
        val db:IgrejaDatabase by lazy {
            Room.databaseBuilder(application.applicationContext, IgrejaDatabase::class.java, "Igrejas.sqlite")
                .build()
        }
        banco = db
    }

    private var _nome = MutableLiveData<String>()
    var nome: LiveData<String> = _nome

    private var _religiao = MutableLiveData<String>()
    var religiao: LiveData<String> = _religiao

    private var _entidade = MutableLiveData<String>()
    var entidade: LiveData<String> = _entidade

    private var _endereco = MutableLiveData<String>()
    var endereco: LiveData<String> = _endereco

    private var _lider = MutableLiveData<String>()
    var lider: LiveData<String> = _lider

    private var _inauguracao = MutableLiveData<Int>()
    var inauguracao: LiveData<Int> = _inauguracao

    fun search(id:Long){
       igreja = FindByIdTask(banco, id).execute().get()
    }

    private inner class FindByIdTask(var db:IgrejaDatabase, var id:Long): AsyncTask<Long, Int, Igreja>(){

        override fun doInBackground(vararg params: Long?): Igreja {
            return db.IgrejaDao().findById(id)
        }

    }
}