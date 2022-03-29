package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book

interface ToBookMapper: Abstract.Mapper {

    fun map(id: Int, name: String): Book

    class Base : ToBookMapper {
        override fun map(id: Int, name: String) = Book(id, name)
    }
}
