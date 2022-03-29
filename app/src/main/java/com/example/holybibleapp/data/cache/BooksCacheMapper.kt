package com.example.holybibleapp.data.cache

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book
import com.example.holybibleapp.data.ToBookMapper

interface BooksCacheMapper: Abstract.Mapper {

    fun map(books: List<Abstract.Object<Book, ToBookMapper>>): List<Book>

    class Base(private val mapper: ToBookMapper) : BooksCacheMapper {
        override fun map(books: List<Abstract.Object<Book, ToBookMapper>>): List<Book> {
            return books.map { it.map(mapper)
            }
        }
    }
}