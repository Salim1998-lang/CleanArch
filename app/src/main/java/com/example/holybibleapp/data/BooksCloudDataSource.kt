package com.example.holybibleapp.data

import com.example.holybibleapp.data.net.BookServerModel
import com.example.holybibleapp.data.net.BooksService

interface BooksCloudDataSource {


    suspend fun fetchBooks(): List<BookServerModel>

    class Base(private val service: BooksService): BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookServerModel> {
            return service.fetchBooks()
        }

    }
}