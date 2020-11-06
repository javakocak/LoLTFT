package com.atilsamancioglu.retrofitkotlin.model

import com.eraykocak.loltft.models.ChampionCategory
import com.eraykocak.loltft.models.RecentItem

class GetChampionResponse (
    val Armor: String,
    val AttackSpeed: String,
    val BannerImg: String,
    val ChampionCategories: List<ChampionCategory>,
    val Damage: String,
    val Description: String,
    val Dps: String,
    val Feature: String,
    val Health: String,
    val Id: Int,
    val Img: String,
    val MagicRes: String,
    val Mana: String,
    val Name: String,
    val Piece: Int,
    val Price: Int,
    val Range: String,
    val RecentItems: List<RecentItem>
)