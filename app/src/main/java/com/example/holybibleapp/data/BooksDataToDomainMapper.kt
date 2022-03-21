package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.data.net.BookServerModel
import com.example.holybibleapp.domain.BookDomain
import java.net.HttpRetryException
import java.net.UnknownHostException

interface BooksDataToDomainMapper: Abstract.Mapper {

    fun map(books: List<BookServerModel>): BookDomain

    fun map(e: Exception): BookDomain

    class Base: BooksDataToDomainMapper{
        override fun map(books: List<BookServerModel>): BookDomain {
            return BookDomain.Success(books)
        }

        override fun map(e: Exception): BookDomain {
            val errorType = when(e) {
                is UnknownHostException -> 0
                is HttpRetryException -> 1
                else -> 2
            }
            return BookDomain.Fail(errorType)
        }

    }

}