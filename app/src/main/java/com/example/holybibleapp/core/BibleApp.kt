package com.example.holybibleapp.core

import android.app.Application
import com.example.holybibleapp.presentation.Base
import com.example.holybibleapp.presentation.BooksCommunication
import com.example.holybibleapp.presentation.MainViewModel
import com.example.holybibleapp.presentation.ResourceProvider

class BibleApp: Application() {

    lateinit var mainViewModel: MainViewModel
    override fun onCreate() {
        super.onCreate()

        val booksInteractor: BooksInteractor = TODO()
        mainViewModel = MainViewModel(booksInteractor, Base(BooksCommunication.Base(), ResourceProvider.Base(this)), BooksCommunication.Base())
    }
}