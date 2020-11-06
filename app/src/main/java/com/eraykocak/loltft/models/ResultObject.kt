package com.eraykocak.loltft.models

import androidx.room.*
import com.eraykocak.loltft.converters.ConverterJsonModels
import com.eraykocak.loltft.converters.ConverterJsonModelsChampionsCat
import com.eraykocak.loltft.converters.ConverterJsonModelsRecentItems
import com.google.gson.annotations.SerializedName


@Entity

data class ResultObject(
    @PrimaryKey(autoGenerate = true)
    var uuid: Int=0,


    @ColumnInfo(name="Armor")
    val Armor: String,
    @ColumnInfo(name="AttackSpeed")
    val AttackSpeed: String,
    @ColumnInfo(name="BannerImg")
    val BannerImg: String,
    @ColumnInfo(name="Damage")
    val Damage: String,
    @ColumnInfo(name="Description")
    val Description: String,
    @ColumnInfo(name="Dps")
    val Dps: String,
    @ColumnInfo(name="Feature")
    val Feature: String,
    @ColumnInfo(name="Health")
    val Health: String,
    @ColumnInfo(name="Id")
    val Id: Int,
    @ColumnInfo(name="Img")
    val Img: String,
    @ColumnInfo(name="MagicRes")
    val MagicRes: String,
    @ColumnInfo(name="Mana")
    val Mana: String,
    @ColumnInfo(name="Name")
    val Name: String,
    @ColumnInfo(name="Piece")
    val Piece: Int,
    @ColumnInfo(name="Price")
    val Price: Int,
    @ColumnInfo(name="Range")
    val Range: String,

    @TypeConverters(ConverterJsonModelsChampionsCat::class)
    @SerializedName("ChampionCategory")
    @ColumnInfo(name="ChampionCategory")
    val ChampionCategories: List<ChampionCategory> = listOf(),

    @TypeConverters(ConverterJsonModelsRecentItems::class)
    @SerializedName("RecentItem")
    @ColumnInfo(name="RecentItem")
    val RecentItems: List<RecentItem> = listOf()
){

}