package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.createDataStore
import androidx.room.Room
import com.example.myapplication.db.AdInfoDb

lateinit var dataStore: DataStore<Preferences>
var db: AdInfoDb? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        dataStore = createDataStore(name = "users")
        db = Room.databaseBuilder(
            this,
            AdInfoDb::class.java, "add_table"
        ).build()
    }
}