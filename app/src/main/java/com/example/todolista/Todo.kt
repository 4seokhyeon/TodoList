package com.example.todolista

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "TrainReservation")
class Todo(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "startingPoint") val title: String,
    @ColumnInfo(name = "destination") val content: String,
    @ColumnInfo(name = "age") var age: Int,
    @ColumnInfo(name = "timestamp") val timestamp: String,
    @ColumnInfo(name = "isChecked") var isChecked: Boolean
): Serializable {
}
