package com.example.myapplication.api

import com.example.myapplication.db.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

    @POST("users")
    suspend fun addUser(@Body user: User): User

}