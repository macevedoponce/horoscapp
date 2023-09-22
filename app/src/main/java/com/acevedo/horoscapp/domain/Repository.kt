package com.acevedo.horoscapp.domain
interface Repository {
    //definimos las cosas que necesitamos de data
    suspend fun getPrediction(sign:String): PredictionModel?
}