package com.example.segundaprova

import android.app.Application
import android.os.AsyncTask
import android.text.Editable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room

@Suppress("DEPRECATION")
class AlteraFragmentViewModel(application: Application): AndroidViewModel(application) {

    var app:Application
    var banco:IgrejaDatabase

    init {
        app = application

        val db:IgrejaDatabase by lazy {
            Room.databaseBuilder(app.applicationContext,IgrejaDatabase::class.java, "Igrejas.sqlite")
                .build()
        }
        banco = db
        //val igreja = FindTask(db,)
    }



    private var id:Long = 0

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

    fun nomeChanged(editable: Editable?){
        _nome.value = editable.toString()
    }

    fun religiaoChanged(editable: Editable?){
        _religiao.value = editable.toString()
    }

    fun entidadeChanged(editable: Editable?){
        _entidade.value = editable.toString()
    }

    fun enderecoChanged(editable: Editable?){
        _endereco.value = editable.toString()
    }

    fun liderChanged(editable: Editable?){
        _lider.value = editable.toString()
    }

    fun inauguracaoChanged(editable: Editable?){
        _inauguracao.value = Integer.parseInt(editable.toString())
    }

    fun updateTask(){

       //UpdateTask(banco, igreja).execute()
    }

    private inner class FindTask(var db:IgrejaDatabase, var id:Long): AsyncTask<Long, Int, Igreja>(){
        override fun doInBackground(vararg params: Long?): Igreja {
            return db.IgrejaDao().findById(id)
        }
    }


    private inner class UpdateTask(var db:IgrejaDatabase, var igreja: Igreja): AsyncTask<Igreja, Int, Boolean>(){
        override fun doInBackground(vararg params: Igreja?): Boolean {
            db.IgrejaDao().edit(igreja)
            return true
        }
    }
}