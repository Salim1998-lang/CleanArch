package com.example.holybibleapp.data.cache

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.core.Book
import com.example.holybibleapp.data.ToBookMapper
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BookDb: RealmObject(), Abstract.Object<Book, ToBookMapper> {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""

    override fun map(mapper: ToBookMapper) = Book(id, name)
}