package com.eraykocak.loltft.models

import androidx.room.*

@Entity
data class RecentItem(
        @PrimaryKey(autoGenerate = true)
        var uuid: Int=0,

        @ColumnInfo(name="Feature")
        val Feature: String,
        @ColumnInfo(name="Id")
         val Id: Int,
        @ColumnInfo(name="Img")
         val Img: String,
       // @ColumnInfo(name="Item1")
       //  @Embedded
       // @Relation(parentColumn = "RecentItem",entityColumn = "Item1")
       //  val Item1: Item1?,
       // @ColumnInfo(name="Item2")
       //  @Embedded
       // @Relation(parentColumn = "RecentItem",entityColumn = "Item2")
       //  val Item2: Item2?,
        @ColumnInfo(name="Name")
         val Name: String
){

}