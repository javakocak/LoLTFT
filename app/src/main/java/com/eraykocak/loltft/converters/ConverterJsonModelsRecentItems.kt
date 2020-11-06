package com.eraykocak.loltft.converters

import androidx.room.TypeConverter
import com.eraykocak.loltft.models.RecentItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ConverterJsonModelsRecentItems {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<RecentItem> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<RecentItem>>() {

        }.type

        return gson.fromJson<List<RecentItem>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<RecentItem>): String {
        return gson.toJson(someObjects)
    }
}