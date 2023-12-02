package com.example.todolista

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dto: Todo)

    @Query("select * from TrainReservation")
    fun list(): LiveData<MutableList<Todo>>

    @Query("select * from TrainReservation where id = (:id)")
    fun selectOne(id: Long): Todo

    @Update
    suspend fun update(dto: Todo)

    @Delete
    fun delete(dto: Todo)
}