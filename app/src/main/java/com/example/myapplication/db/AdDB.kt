package com.example.myapplication.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AddAd::class], version = 1)
abstract class AdInfoDb : RoomDatabase() {
    abstract fun adDao(): AdDao
}