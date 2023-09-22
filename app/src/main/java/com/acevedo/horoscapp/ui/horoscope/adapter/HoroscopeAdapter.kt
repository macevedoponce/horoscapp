package com.acevedo.horoscapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acevedo.horoscapp.R
import com.acevedo.horoscapp.domain.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList:List<HoroscopeInfo> = emptyList(),
    private val onItemSelected:(HoroscopeInfo) ->Unit):
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(list: List<HoroscopeInfo>){
        horoscopeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        //crea la instancia del view holder
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope,parent,false)
        )
    }

    override fun getItemCount() = horoscopeList.size


    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        //decirle al viewholder lo que tiene que pintar
        holder.render(horoscopeList[position], onItemSelected)
    }
}