package com.acevedo.horoscapp.data

import android.util.Log
import com.acevedo.horoscapp.data.network.HoroscopeApiService
import com.acevedo.horoscapp.data.network.response.PredictionResponse
import com.acevedo.horoscapp.domain.PredictionModel
import com.acevedo.horoscapp.domain.Repository
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService): Repository {
    override suspend fun getPrediction(sign: String):PredictionModel? {
        //Petición retrofit
        runCatching {apiService.getHoroscope(sign)}
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("miguel","tenemos un error ${it.message}") }

        return null
    }
}