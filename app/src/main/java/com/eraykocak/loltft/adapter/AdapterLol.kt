package com.eraykocak.loltft.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.eraykocak.loltft.R
import com.eraykocak.loltft.models.ResponseClass
import com.eraykocak.loltft.models.ResultObject
import com.eraykocak.loltft.newModelAllinOne.AllModelsAllinOne
import com.eraykocak.loltft.utils.Constants
import com.eraykocak.loltft.utils.downloadFromURL
import com.eraykocak.loltft.utils.placeHolderProggressBar
import com.eraykocak.loltft.view.HomeFragmentDirections
import kotlinx.android.synthetic.main.home_grid_layout.view.*

class AdapterLol(val lolList: ArrayList<ResultObject>): RecyclerView.Adapter<AdapterLol.LoLViewHolder>() {

    class LoLViewHolder(var view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoLViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.home_grid_layout,parent,false)
        return LoLViewHolder(view)
    }

    override fun onBindViewHolder(holder: LoLViewHolder, position: Int) {
        holder.view.textNameGrid.text=lolList[position].Name
        holder.view.imageLolGrid.downloadFromURL((Constants.BASE_URL_IMG+lolList[position].Img), placeHolderProggressBar(holder.view.context))

        holder.view.setOnClickListener {
            val action= HomeFragmentDirections.actionNavHomeToLoLDetailFragment(lolList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return lolList.size
    }

    fun updateLolList(newLolList: List<ResultObject>){
        lolList.clear()
        lolList.addAll(newLolList)
        notifyDataSetChanged()
    }
}