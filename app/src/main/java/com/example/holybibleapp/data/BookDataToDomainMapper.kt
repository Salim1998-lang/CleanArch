package com.example.holybibleapp.data

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.domain.BookDomain
import com.example.holybibleapp.domain.BooksDomain

interface BookDataToDomainMapper: Abstract.Mapper {

    fun map(id: Int, name: String): BookDomain
}