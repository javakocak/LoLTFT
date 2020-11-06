package com.eraykocak.loltft.converters

import androidx.room.TypeConverter
import com.eraykocak.loltft.models.ResultObject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ConverterJsonModels {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<ResultObject> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<ResultObject>>() {

        }.type

        return gson.fromJson<List<ResultObject>>(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<ResultObject>): String {
        return gson.toJson(someObjects)
    }
}


/*
 @TypeConverter // note this annotation
    fun fromResponseClass(resultObject: List<ResultObject?>?): String? {
        if (resultObject == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<ResultObject?>?>() {}.type
        return gson.toJson(resultObject, type)
    }

    @TypeConverter // note this annotation
    fun toOptionValuesList(optionValuesString: String?): List<ResultObject>? {
        if (optionValuesString == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<ResultObject?>?>() {}.type
        return gson.fromJson<List<ResultObject>>(optionValuesString, type)
    }
 */