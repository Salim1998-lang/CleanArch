package com.example.holybibleapp.data

import com.example.holybibleapp.data.net.BookCloud
import com.example.holybibleapp.data.net.BookService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface BooksCloudDataSource {

    suspend fun fetchBooks(): List<BookCloud>

    class Base(
        private val service: BookService,
        private val gson: Gson,
    ) : BooksCloudDataSource {

        override suspend fun fetchBooks(): List<BookCloud> =
            gson.fromJson(
                service.fetchBooks().string(),
                object : TypeToken<List<BookCloud>>() {}.type
            )
    }

}