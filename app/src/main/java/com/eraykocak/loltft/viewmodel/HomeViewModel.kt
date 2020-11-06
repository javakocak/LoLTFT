package com.eraykocak.loltft.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.eraykocak.loltft.DAO.lolDatabase
import com.eraykocak.loltft.models.GetChampionRequest
import com.eraykocak.loltft.models.ResponseClass
import com.eraykocak.loltft.newModelAllinOne.AllModelsAllinOne
import com.eraykocak.loltft.service.LolAPIService
import com.eraykocak.loltft.utils.Constants
import com.eraykocak.loltft.utils.CustomSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch



class HomeViewModel(application: Application):BaseViewModel(application) {

    private val lolAPIService = LolAPIService()
    private val disposable= CompositeDisposable() //-------> internetten herhangi birşey indirilirken hafızada sürekli veri tutar. hafızayı açmak için temizlemek için dispossible bu işe yarar.
    private var customSharedPreferences= CustomSharedPreferences(getApplication())
    private var resfleshTime= 10*60*1000*1000*1000L // nano saniyeye çevirme long halinde


    val lolChams = MutableLiveData<ResponseClass>()
    val lolError = MutableLiveData<Boolean>()
    val lolLoading = MutableLiveData<Boolean>()



    fun refleshData(){
        val updateTime=customSharedPreferences.getTime()
        if (updateTime!=null && updateTime!=0L && System.nanoTime()-updateTime<resfleshTime){
            getDataFromAPI()
        }else{
            getDataFromSQLite()
        }

    }

    fun refresfFromAPI(){
        getDataFromAPI()
    }

    private fun getDataFromSQLite(){
        launch {
            val lolresults= lolDatabase(getApplication()).lolDao().getAllResponseClass()
            showLoLChamps(lolresults)
            Toast.makeText(getApplication(),"LoL From SQL",Toast.LENGTH_SHORT).show()
        }
    }

    //veri aldıgımız yer
    private fun getDataFromAPI(){
        lolLoading.value=true //------> ilk olarak progress bar görünmesi için

        disposable.add(
                lolAPIService.getChampion(GetChampionRequest(Constants.AppName,Constants.ApiKey,Constants.Language))
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<ResponseClass>(){
                            override fun onSuccess(t: ResponseClass) {
                                lolChams.value=t
                                lolError.value=false
                                lolLoading.value=false
                                //storeInSQLite(t)
                                Toast.makeText(getApplication(),"LoL From API",Toast.LENGTH_SHORT).show()
                            }

                            override fun onError(e: Throwable) {
                                lolLoading.value=false
                                lolError.value=true
                                e.printStackTrace()
                            }
                        })
        )
    }
    private fun showLoLChamps(t: ResponseClass){
        launch {
            lolChams.value=t
            lolError.value=false
            lolLoading.value=false
        }
    }
    private fun storeInSQLite(list: List<ResponseClass>){

        launch {
            val dao= lolDatabase(getApplication()).lolDao()
            dao.deletedAllResponseClass()
            val listLong= dao.insertAll(*list.toTypedArray())       //(*listOf(list).toTypedArray())
            var i=0
            while (i< listOf(list).size){
                list[i].uuid=listLong[i].toInt()
                i=i+1
            }
           //showLoLChamps(list)
        }

        customSharedPreferences.saveTime(System.nanoTime())
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}