package com.example.myapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "add_table")
data class AddAd(
    val province: String,
    val city: String,
    val nearby: String,
    val date: String,
    val kind: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}