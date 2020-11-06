package com.eraykocak.loltft.DAO

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eraykocak.loltft.converters.ConverterJsonModels
import com.eraykocak.loltft.converters.ConverterJsonModelsChampionsCat
import com.eraykocak.loltft.converters.ConverterJsonModelsRecentItems
import com.eraykocak.loltft.models.*
import com.eraykocak.loltft.newModelAllinOne.AllModelsAllinOne

@Database(entities = arrayOf(ResponseClass::class,ResultObject::class,RecentItem::class,ChampionCategory::class,
Item1::class,Item2::class),version = 1)
@TypeConverters(ConverterJsonModels::class,
    ConverterJsonModelsChampionsCat::class, ConverterJsonModelsRecentItems::class)

abstract class lolDatabase : RoomDatabase(){
    abstract fun lolDao(): LoLDAO

    companion object{
        @Volatile private var instance: lolDatabase?=null
        private val lock=Any()
        operator fun invoke(context: Context)= instance?: synchronized(lock){
            instance?: makeDatabase(context).also {
                instance=it
            }

        }
        private fun makeDatabase(context: Context)=
                Room.databaseBuilder(context.applicationContext,lolDatabase::class.java,"loldatabase").build()

    }
}