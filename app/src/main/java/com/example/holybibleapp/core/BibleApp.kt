package com.example.holybibleapp.core

import android.app.Application
import com.example.holybibleapp.data.BooksCloudDataSource
import com.example.holybibleapp.data.BooksCloudMapper
import com.example.holybibleapp.data.BooksRepository
import com.example.holybibleapp.data.cache.BookCacheMapper
import com.example.holybibleapp.data.cache.BooksCacheDataSource
import com.example.holybibleapp.data.cache.BooksCacheMapper
import com.example.holybibleapp.data.cache.RealmProvider
import com.example.holybibleapp.data.net.BookCloudMapper
import com.example.holybibleapp.data.net.BookService
import retrofit2.Retrofit
import com.example.holybibleapp.data.BooksDataToDomainMapper
import com.example.holybibleapp.domain.BooksInteractor
import com.example.holybibleapp.presentation.Base
import com.example.holybibleapp.presentation.BooksCommunication
import com.example.holybibleapp.presentation.MainViewModel
import com.example.holybibleapp.presentation.ResourceProvider

class BibleApp: Application() {

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }
    lateinit var mainViewModel: MainViewModel


    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        val service = retrofit.create(BookService::class.java)
        val cloudDataSource = BooksCloudDataSource.Base(service)
        val cacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())
        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())
        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())

        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
        val booksInteractor = BooksInteractor.Base(booksRepository, BooksDataToDomainMapper.Base())
        val booksInteractor: BooksInteractor = TODO()
        mainViewModel = MainViewModel(booksInteractor, Base(BooksCommunication.Base(), ResourceProvider.Base(this)),
    }
}