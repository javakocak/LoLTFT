package com.eraykocak.loltft.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.eraykocak.loltft.view.LoLDetailFragmentArgs
import com.eraykocak.loltft.R
import com.eraykocak.loltft.models.GetChampionRequest
import com.eraykocak.loltft.models.ResponseClass
import com.eraykocak.loltft.models.ResultObject
import com.eraykocak.loltft.service.LolAPIService
import com.eraykocak.loltft.utils.Constants
import com.eraykocak.loltft.utils.CustomSharedPreferences
import com.eraykocak.loltft.utils.downloadFromURL
import com.eraykocak.loltft.utils.placeHolderProggressBar
import com.eraykocak.loltft.viewmodel.LoLDetailModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_lol_detail.*



class LoLDetailFragment : Fragment() {
    var lolUuid =0
    private lateinit var viewModel : LoLDetailModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lol_detail, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            lolUuid= LoLDetailFragmentArgs.fromBundle(it).lolUuid
        }

        viewModel= ViewModelProviders.of(this).get(LoLDetailModel::class.java)
        viewModel.getDataFromRoom(lolUuid)

        obseveLiveData()
    }

    private fun obseveLiveData(){
        viewModel.lolModelLiveData.observe(viewLifecycleOwner, Observer {champs ->
            champs?.let {
            //txtManaEdit.text=it.Mana
            //txtCanEdit.text=champs.Health
            //txtDpsEdit.text=champs.Dps
            //txtMenzilEdit.text=champs.Range
            //txtZirhEdit.text=champs.Armor
            //txtBuyuDirenciEdit.text=champs.MagicRes
            //txtSaldiriHasariEdit.text=champs.Damage
            //txtSaldiriHiziEdit.text=champs.AttackSpeed
            //context?.let {
             //      imageViewTitel.downloadFromURL(Constants.BASE_URL_IMG,
             //          placeHolderProggressBar(it))
              //  }

            }

        })
    }
}