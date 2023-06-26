package com.example.myapplication.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.db.AddAd

@Dao
interface AdDao {

    @Insert
    suspend fun addAdd(data: AddAd)

    @Delete
    suspend fun deleteAd(data: AddAd)

    @Query("SELECT * FROM add_table")
    suspend fun getAllAdds(): List<AddAd>

    @Query("DELETE FROM add_table")
    suspend fun deleteAllAdds()
}