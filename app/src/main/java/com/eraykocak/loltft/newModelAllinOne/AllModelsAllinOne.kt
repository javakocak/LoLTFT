package com.eraykocak.loltft.newModelAllinOne

import androidx.room.*
import com.eraykocak.loltft.converters.ConverterJsonModels
import com.eraykocak.loltft.converters.ConverterJsonModelsChampionsCat
import com.eraykocak.loltft.converters.ConverterJsonModelsRecentItems
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class AllModelsAllinOne(){}
    /*
    @PrimaryKey(autoGenerate = true)
    var uuid: Int=0,
    @ColumnInfo(name="ResultMessage")
    @Expose
    val ResultMessage: Int,

    @ColumnInfo(name="StatusCode")
    @Expose
    val StatusCode: Int,


    @TypeConverters(ConverterJsonModels::class)
    @ColumnInfo(name="ResultObject")
    @Expose
    @SerializedName("ResultObject")
    val myResultObject: List<ResultObject> = listOf(),
)
{
    @Entity
    data class ResultObject(
        @PrimaryKey(autoGenerate = true) var uuid: Int=0,
        @ColumnInfo(name="Armor")val Armor: String,
        @ColumnInfo(name="AttackSpeed")val AttackSpeed: String,
        @ColumnInfo(name="BannerImg")val BannerImg: String,
        @ColumnInfo(name="Damage")val Damage: String,
        @ColumnInfo(name="Description")val Description: String,
        @ColumnInfo(name="Dps")val Dps: String,
        @ColumnInfo(name="Feature")val Feature: String,
        @ColumnInfo(name="Health")val Health: String,
        @ColumnInfo(name="Id")val Id: Int,
        @ColumnInfo(name="Img")val Img: String,
        @ColumnInfo(name="MagicRes")val MagicRes: String,
        @ColumnInfo(name="Mana")val Mana: String,
        @ColumnInfo(name="Name")val Name: String,
        @ColumnInfo(name="Piece")val Piece: Int,
        @ColumnInfo(name="Price")val Price: Int,
        @ColumnInfo(name="Range")val Range: String,

        @SerializedName("ChampionCategory")
        @TypeConverters(ConverterJsonModelsChampionsCat::class)
        @ColumnInfo(name="ChampionCategory")
        val ChampionCategories: List<ChampionCategory>,

        @SerializedName("RecentItem")
        @TypeConverters(ConverterJsonModelsRecentItems::class)
        @ColumnInfo(name="RecentItem")
        val RecentItems: List<RecentItem>
    ) {
        data class ChampionCategory(
            @ColumnInfo(name="Feature")val Feature: String,
            @ColumnInfo(name="Id")val Id: Int,
            @ColumnInfo(name="Img")val Img: String,
            @ColumnInfo(name="Name")val Name: String
        )

        data class RecentItem(
            @ColumnInfo(name="Feature")val Feature: String,
            @ColumnInfo(name="Id")val Id: Int,
            @ColumnInfo(name="Img")val Img: String,
            @ColumnInfo(name="myItem1")val myItem1: Item1,
            @ColumnInfo(name="myItem2")val myItem2: Item2,
            @ColumnInfo(name="Name")val Name: String
        ) {
            data class Item1(
                @ColumnInfo(name="Feature")val Feature: String,
                @ColumnInfo(name="Id")val Id: Int,
                @ColumnInfo(name="Img")val Img: String,
                @ColumnInfo(name="Name")val Name: String
            )

            data class Item2(
                @ColumnInfo(name="Feature") val Feature: String,
                @ColumnInfo(name="Id") val Id: Int,
                @ColumnInfo(name="Img")val Img: String,
                @ColumnInfo(name="Name") val Name: String
            )
        }
    }

     */
