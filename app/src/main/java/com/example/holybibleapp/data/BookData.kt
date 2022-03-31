package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.domain.BookDomain

class BookData(private val id: Int, private val name: String) :
    Abstract.Object<BookDomain, BookDataToDomainMapper>, BookDataToDbMapper{
    override fun map(mapper: BookDataToDomainMapper): BookDomain {
        return mapper.map(id, name)
    }

    override fun mapToDb(id: Int, name: String) {

    }
}