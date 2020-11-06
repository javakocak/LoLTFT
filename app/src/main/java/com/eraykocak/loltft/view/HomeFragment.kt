package com.eraykocak.loltft.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.eraykocak.loltft.R
import com.eraykocak.loltft.adapter.AdapterLol
import com.eraykocak.loltft.models.ResponseClass
import com.eraykocak.loltft.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel


    private val lolAdapter = AdapterLol(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel= ViewModelProvider(this).get(HomeViewModel::class.java)

        recyclerViewHome.layoutManager= GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
        recyclerViewHome.adapter=lolAdapter
        viewModel.refleshData()

        //-------> SwipeReflesh ---------------------
        swipeRefleshLayout.setOnRefreshListener {
            recyclerViewHome.visibility=View.GONE
            lolErrorMesage.visibility=View.GONE
            lolLoading.visibility=View.VISIBLE
            viewModel.refresfFromAPI()

            swipeRefleshLayout.isRefreshing=false

        }
            observeLiveData()
    }

    fun observeLiveData(){
        viewModel.lolChams.observe(viewLifecycleOwner, Observer { lolChamps ->
            lolChamps?.let {
                recyclerViewHome.visibility = View.VISIBLE
                lolAdapter.updateLolList(lolChamps.ResultObject)
            }

        })
        viewModel.lolError.observe(viewLifecycleOwner, Observer { lolError ->
            lolError?.let {
                if (it){
                    lolErrorMesage.visibility=View.VISIBLE
                }else{
                    lolErrorMesage.visibility=View.GONE
                }
            }

        })
        viewModel.lolLoading.observe(viewLifecycleOwner, Observer { lolLoad ->
            lolLoad?.let {
                if (it){
                    lolLoading.visibility=View.VISIBLE
                    recyclerViewHome.visibility=View.GONE
                    lolErrorMesage.visibility=View.GONE
                }else{
                    lolLoading.visibility=View.GONE
                }
            }

        })
    }
}