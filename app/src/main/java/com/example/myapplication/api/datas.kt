package com.example.myapplication.api

data class GetResponse(val ok: Boolean, val result: String)

data class PostRequestBody(
    val action: String,
    val params: Map<String, Any>
)

data class PostResponse(val ok: Boolean, val result: Any)