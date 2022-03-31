package com.example.holybibleapp.presentation

import com.example.holybibleapp.data.BookData
import com.example.holybibleapp.domain.BooksDomainToUiMapper
import com.example.holybibleapp.domain.ErrorType

class Base(
    private val resourceProvider: ResourceProvider
) : BooksDomainToUiMapper {
    override fun map(books: List<BookData>): BooksUi {
        return BooksUi.Success(books)
    }

    override fun map(errorType: ErrorType): BooksUi {
        return BooksUi.Fail(errorType, resourceProvider)
    }
}