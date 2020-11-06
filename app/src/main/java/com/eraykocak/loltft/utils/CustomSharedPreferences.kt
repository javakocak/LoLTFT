package com.eraykocak.loltft.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class CustomSharedPreferences {
    companion object{
        private val PREFERENCES_TIME="prefecences time"
        private var sharedPreferences: SharedPreferences?=null
        private val lock=Any()
        @Volatile private var instance: CustomSharedPreferences?=null
        operator fun invoke(context: Context): CustomSharedPreferences= instance?: synchronized(lock){
            instance?: makeCustomSharedPrefarences(context).also {
                instance= it
            }
        }
        private fun makeCustomSharedPrefarences(context: Context): CustomSharedPreferences{
            sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPreferences()
        }
    }
    fun saveTime(time: Long){
        sharedPreferences?.edit(commit = true){
            putLong(PREFERENCES_TIME,time)
        }
    }
    fun getTime()= sharedPreferences?.getLong(PREFERENCES_TIME,0)
}