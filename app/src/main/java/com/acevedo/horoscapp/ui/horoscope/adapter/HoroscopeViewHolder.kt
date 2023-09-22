package com.acevedo.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.acevedo.horoscapp.databinding.ItemHoroscopeBinding
import com.acevedo.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){
        val context = binding.tvTitle.context

        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        binding.parent.setOnClickListener{
            startRotationAnimation(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)})
//            onItemSelected(horoscopeInfo)
        }
    }

    private fun startRotationAnimation(view:View, newLambda:() -> Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator() // flujo de la animación
            rotationBy(360f)//rotacion de 360°
            withEndAction{
                //cuando termina el accion de la animación se ejecuta el nuevo lambda, es decir pasar a otra vista
                newLambda()
            }
            start()
        }
    }
}