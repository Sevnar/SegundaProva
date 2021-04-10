package com.example.segundaprova

import androidx.room.*


@Dao
interface IgrejaDao {

    @Insert
    fun insert(igreja: Igreja)

    @Update
    fun edit(igreja: Igreja)

    @Query("SELECT * FROM igreja")
    fun listAll(): List<Igreja>

    @Query("SELECT * FROM igreja WHERE id = :id")
    fun findById(id: Long): Igreja

    @Delete
    fun delete(igreja: Igreja)
}