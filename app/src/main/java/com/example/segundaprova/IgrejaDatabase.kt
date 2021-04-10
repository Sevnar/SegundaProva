package com.example.segundaprova

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Igreja::class])
abstract class IgrejaDatabase: RoomDatabase() {

    abstract fun IgrejaDao():IgrejaDao

}