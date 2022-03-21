package com.example.holybibleapp.domain

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.data.net.BookServerModel
import com.example.holybibleapp.presentation.BookUi

sealed class BookDomain: Abstract.Object<BookUi, Abstract.Mapper.Empty>() {

    class Success(private val books: List<BookServerModel>): BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }

    }

    class Fail(e: Int) : BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }
    }

}
