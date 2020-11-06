package com.eraykocak.loltft.converters

import androidx.room.TypeConverter
import com.eraykocak.loltft.models.ChampionCategory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ConverterJsonModelsChampionsCat {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<ChampionCategory> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<ChampionCategory>>() {

        }.type

        return gson.fromJson<List<ChampionCategory>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<ChampionCategory>): String {
        return gson.toJson(someObjects)
    }
}