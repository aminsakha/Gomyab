package com.example.myapplication.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SkyroomApi {
    @GET("skyroom/api/apikey-23600573-5-870c3af93209ed5af898edbe58e9e82b")
    fun getResponse(): Call<GetResponse>

    @POST("skyroom/api/apikey-23600573-5-870c3af93209ed5af898edbe58e9e82b")
    fun postRequest(@Body requestBody: PostRequestBody): Call<PostResponse>
}