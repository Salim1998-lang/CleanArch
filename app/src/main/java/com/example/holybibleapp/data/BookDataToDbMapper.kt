package com.example.holybibleapp.data

import io.realm.Realm

interface BookDataToDbMapper {

    fun mapToDb(id: Int, name: String)

    class Base(private val realm: Realm): BookDataToDbMapper {
        override fun mapToDb(id: Int, name: String) {
            realm.createObject()
        }

    }
}