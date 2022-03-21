package com.example.holybibleapp.data.net

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.data.BookData
import com.google.gson.annotations.SerializedName

data class BookServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String,
): Abstract.Object<BookData, BookServerToDataMapper>() {
    override fun map(mapper: BookServerToDataMapper) = mapper.map(id, name)
}
