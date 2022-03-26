package com.example.holybibleapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book
import com.example.holybibleapp.domain.BooksDomainToUiMapper
import com.example.holybibleapp.domain.BooksInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val booksInteractor: BooksInteractor,
    private val booksDomainToUiMapper: BooksDomainToUiMapper,
    private val communication: BooksCommunication,

    ): ViewModel() {

    fun fetchBooks() = viewModelScope.launch(Dispatchers.IO) {
        val result = booksInteractor.fetchBooks()
        withContext(Dispatchers.Main) {
            result.map(booksDomainToUiMapper).map(Abstract.Mapper.Empty())
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<Book>>) {
        communication.observeSuccess(owner, observer)
    }

}