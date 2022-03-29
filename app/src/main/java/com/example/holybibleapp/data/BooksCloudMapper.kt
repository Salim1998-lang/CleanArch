package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book

interface BooksCloudMapper : Abstract.Mapper {

    fun map(cloudList: List<Abstract.Object<Book, ToBookMapper>>): List<Book>

    class Base(private val bookMapper: ToBookMapper) : BooksCloudMapper {
        override fun map(cloudList: List<Abstract.Object<Book, ToBookMapper>>) = cloudList.map {
            it.map(bookMapper)
        }
    }
}