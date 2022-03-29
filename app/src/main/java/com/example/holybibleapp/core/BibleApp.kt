package com.example.holybibleapp.core

import android.app.Application
import com.example.holybibleapp.data.*
import com.example.holybibleapp.data.cache.BooksCacheDataSource
import com.example.holybibleapp.data.cache.RealmProvider
import com.example.holybibleapp.data.net.BookService
import retrofit2.Retrofit
import com.example.holybibleapp.data.cache.BooksCacheMapper
import com.example.holybibleapp.domain.BooksInteractor
import com.example.holybibleapp.presentation.Base
import com.example.holybibleapp.presentation.BooksCommunication
import com.example.holybibleapp.presentation.MainViewModel
import com.example.holybibleapp.presentation.ResourceProvider
import com.google.gson.Gson
import io.realm.Realm

class BibleApp : Application() {

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    lateinit var mainViewModel: MainViewModel


    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        val service = retrofit.create(BookService::class.java)
        val cloudDataSource = BooksCloudDataSource.Base(service, Gson())
        val cacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())
        val bookMapper = ToBookMapper.Base()
        val booksCloudMapper = BooksCloudMapper.Base(bookMapper)
        val booksCacheMapper = BooksCacheMapper.Base(bookMapper)

        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
        val booksInteractor = BooksInteractor.Base(booksRepository, BooksDataToDomainMapper.Base())
        val communication = BooksCommunication.Base()
        mainViewModel = MainViewModel(
            booksInteractor,
            Base(communication, ResourceProvider.Base(this)),
            communication
        )
    }
}