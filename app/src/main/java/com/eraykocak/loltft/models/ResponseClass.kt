package com.eraykocak.loltft.models

import androidx.room.*
import com.eraykocak.loltft.converters.ConverterJsonModels
import com.google.gson.annotations.Expose

@Entity
data class ResponseClass(

        @PrimaryKey(autoGenerate = true)
        var uuid:Int=0,

        @ColumnInfo(name="ResultMessage")
        @Expose
        val ResultMessage: String="",

        @ColumnInfo(name="StatusCode")
        @Expose
        val StatusCode: Int,

        @TypeConverters(ConverterJsonModels::class)
        @ColumnInfo(name="ResultObject")
        @Expose
        val ResultObject: List<ResultObject> = listOf()

){

}