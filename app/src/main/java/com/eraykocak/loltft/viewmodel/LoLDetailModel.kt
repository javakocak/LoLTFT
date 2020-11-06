package com.eraykocak.loltft.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eraykocak.loltft.DAO.lolDatabase
import com.eraykocak.loltft.models.GetChampionRequest
import com.eraykocak.loltft.models.ResponseClass
import com.eraykocak.loltft.models.ResultObject
import com.eraykocak.loltft.service.LolAPIService
import com.eraykocak.loltft.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

class LoLDetailModel(application: Application): BaseViewModel(application) {
    val lolModelLiveData =MutableLiveData<List<ResultObject>>()


/*
    private val lolAPIService = LolAPIService()
    private val disposable= CompositeDisposable() //-------> internetten herhangi birşey indirilirken hafızada sürekli veri tutar. hafızayı açmak için temizlemek için dispossible bu işe yarar.

    val lolChams = MutableLiveData<ResultObject>()
    val lolError = MutableLiveData<Boolean>()
    val lolLoading = MutableLiveData<Boolean>()

    fun getDataFromAPI(){

        disposable.add(
            lolAPIService.getChapionModel(
                GetChampionRequest(
                    Constants.AppName,
                    Constants.ApiKey,
                    Constants.Language)
            )
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ResultObject>(){
                    override fun onSuccess(t: ResultObject) {
                        lolChams.value=t
                        lolError.value=false
                        lolLoading.value=false
                    }

                    override fun onError(e: Throwable) {
                        lolLoading.value=false
                        lolError.value=true
                        e.printStackTrace()
                    }
                })
        )
    }

 */

    private fun showLoLChamps(t: List<ResultObject>){
        launch {
            lolModelLiveData.value=t

        }
    }
    private fun storeInSQLite(list: List<ResultObject>){

        launch {
            val dao= lolDatabase(getApplication()).lolDao()
            dao.deletedAllResultObject()
            val listLong= dao.insertAllRO(*list.toTypedArray())
            var i=0
            while (i< listOf(list).size){
                list[i].uuid=listLong[i].toInt()
                i=i+1
            }
            showLoLChamps(list)
        }

    }


    fun getDataFromRoom(uuid:Int){
        launch {
            val dao=lolDatabase(getApplication()).lolDao()
            val champ=dao.getResultObject(uuid)
            lolModelLiveData.value=champ
        }

    }


}