package com.example.holybibleapp.data.net

import com.example.holybibleapp.core.Abstract
import com.example.holybibleapp.data.BookData
import com.example.holybibleapp.data.ToBookMapper
import com.google.gson.annotations.SerializedName

data class BookCloud(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String,
    ): Abstract.Object<BookData, ToBookMapper> {
    override fun map(mapper: ToBookMapper): BookData {
        return mapper.map(id, name)
    }

}
