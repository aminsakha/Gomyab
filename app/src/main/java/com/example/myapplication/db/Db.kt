package com.example.myapplication

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import kotlinx.coroutines.flow.first

suspend fun save(key: String, value: String) {
    val dataStoreKey = preferencesKey<String>(key)
    dataStore.edit { users ->
        users[dataStoreKey] = value
    }
}

suspend fun read(key: String): String? {
    val dataStoreKey = preferencesKey<String>(key)
    val preferences = dataStore.data.first()
    return preferences[dataStoreKey]
}