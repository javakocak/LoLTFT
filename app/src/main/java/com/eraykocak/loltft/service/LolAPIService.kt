package com.eraykocak.loltft.service

import com.atilsamancioglu.retrofitkotlin.model.BaseResponse
import com.atilsamancioglu.retrofitkotlin.model.GetChampionResponse
//import com.eraykocak.loltft.BuildConfig
import com.eraykocak.loltft.models.GetChampionRequest
import com.eraykocak.loltft.models.ResponseClass
import com.eraykocak.loltft.models.ResultObject
import com.eraykocak.loltft.newModelAllinOne.AllModelsAllinOne
import com.facebook.stetho.okhttp3.BuildConfig

import com.facebook.stetho.okhttp3.StethoInterceptor
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class LolAPIService {

    private val BASE_URL = "https://femdecor.com/"

    private val client = OkHttpClient.Builder().let {
        it.retryOnConnectionFailure(true)
        //it.connectTimeout(10, TimeUnit.SECONDS)
        //it.readTimeout(30, TimeUnit.SECONDS)
        //it.writeTimeout(10, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            it.addNetworkInterceptor(StethoInterceptor())
        }
        it
    }.build()

    private val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            //.client(client)
            .build()
            .create(LolAPI::class.java)

    fun getChampion(getChampionRequest: GetChampionRequest): Single<ResponseClass> {
        return api.getData(getChampionRequest)
    }
    //fun getChapionModel(getChampionRequest: GetChampionRequest): Single<ResultObject>{
    //    return api.getDataResultObject(getChampionRequest)
    //}


}

