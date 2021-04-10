package com.example.segundaprova

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Igreja(var nome:String, var religiao:String, var entidade:String, var endereco:String, var lider:String, var inauguracao:Int){

    @PrimaryKey(autoGenerate = true)
    var id:Long = 0


}
