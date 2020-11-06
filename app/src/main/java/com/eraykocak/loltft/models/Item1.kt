package com.eraykocak.loltft.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Item1(
        @ColumnInfo(name="Feature")
    val Feature: String,
        @ColumnInfo(name="Id")
    val Id: Int,
        @ColumnInfo(name="Img")
    val Img: String,
        @ColumnInfo(name="Name")
    val Name: String

){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int=0
}