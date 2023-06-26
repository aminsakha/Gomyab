package com.example.myapplication.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "add_table")
data class AddAd(
    val label: String,
    val province: String,
    val city: String,
    val nearby: String,
    val date: String,
    val kind: String,
) {
    override fun toString(): String {
        return "کالای $label \n موقعیت : $province , $city , $nearby \n نوع : $kind \nتاریخ :  $date"
    }

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}