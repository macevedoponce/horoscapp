package com.acevedo.horoscapp.data.network.response

import com.acevedo.horoscapp.motherObject.HoroscopeMotherObject
import io.kotlintest.shouldBe
import org.junit.Assert.*
import org.junit.Test

class PredictionResponseTest{
    @Test
    fun `toDomain should return a correct PredictionModel`(){ //comillas simples izquierda (alt + 96)
        //Given - infomacion necesario para el test
        val horoscopeResponse = HoroscopeMotherObject.anyResponse //.copy(sign = "taurus") -> por si necesitas cambiar el sign

        //When - cuando algo ocurra
        val predictionModel = horoscopeResponse.toDomain()

        //Then - verificamos que paso algo
        predictionModel.sign shouldBe  horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}