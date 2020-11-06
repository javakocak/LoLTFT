package com.eraykocak.loltft.service

import com.eraykocak.loltft.models.GetChampionRequest
import com.eraykocak.loltft.models.ResponseClass
import com.eraykocak.loltft.models.ResultObject
import com.eraykocak.loltft.newModelAllinOne.AllModelsAllinOne
import io.reactivex.Single
import retrofit2.http.*


interface LolAPI {

    @POST("champion/getChampions")
    fun getData(@Body requestModel: GetChampionRequest): Single<ResponseClass>
    //fun getDataResultObject(@Body resultObjectModel: GetChampionRequest): Single<ResultObject>

}