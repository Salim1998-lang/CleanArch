package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.domain.BooksDomain

interface BooksDataToDomainMapper: Abstract.Mapper {

    fun map(books: List<BookData>) : BooksDomain

    fun map(e: Exception) : BooksDomain

    class Base: BooksDataToDomainMapper {
        override fun map(books: List<BookData>) = BooksDomain.Success(books)
        override fun map(e: Exception) = BooksDomain.Fail(e)

    }
}