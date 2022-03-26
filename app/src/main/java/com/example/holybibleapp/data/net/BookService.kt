package com.example.holybibleapp.data.net

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface BookService {

    @GET("books")
    suspend fun fetchBooks(): ResponseBody

}