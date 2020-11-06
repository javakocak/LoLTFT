package com.eraykocak.loltft.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.eraykocak.loltft.models.ResponseClass

import com.eraykocak.loltft.models.ResultObject
import com.eraykocak.loltft.newModelAllinOne.AllModelsAllinOne

@Dao
interface LoLDAO {

    @Insert()
    suspend fun insertAll(vararg lolResponceClass: ResponseClass): List<Long>
    @Query("SELECT*FROM responseclass")
    suspend fun getAllResponseClass(): ResponseClass
    @Query("SELECT*FROM responseclass WHERE uuid= :responceId")
    suspend fun getResponseClass(responceId : Int) : ResponseClass
    @Query("DELETE FROM responseclass")
    suspend fun deletedAllResponseClass()


    @Insert()
    suspend fun insertAllRO(vararg lolResultObject: ResultObject): List<Long>
    @Query("SELECT*FROM resultobject")
    suspend fun getAllResultObject(): ResultObject
    @Query("SELECT*FROM resultobject WHERE uuid= :resultojectId")
    suspend fun getResultObject(resultojectId : Int) : List<ResultObject>
    @Query("DELETE FROM responseclass")
    suspend fun deletedAllResultObject()

}