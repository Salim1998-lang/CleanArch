package com.example.holybibleapp.presentation

import com.example.holybibleapp.R
import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.domain.ErrorType

sealed class BooksUi: Abstract.Object<Unit, BooksCommunication> {

    class Success(
        private val books: List<Book>): BooksUi() {
        override fun map(mapper: BooksCommunication) {
            val booksUi = books.map {
                BookUi.Base(it.id, it.name)
            }
            mapper.map(booksUi)
        }
    }

    class Fail(
        private val errorType: ErrorType,
        private val resourceProvider: ResourceProvider
        ): BooksUi() {
        override fun map(mapper: BooksCommunication) {
            val message = when(errorType) {
                ErrorType.NO_CONNECTION -> R.string.no_connection_message
                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable
                else -> R.string.something_went_error
            }
            val messageId = resourceProvider.getString(message)
            mapper.map(listOf(BookUi.Fail(messageId)))
        }
    }

}
