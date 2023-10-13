package com.acevedo.horoscapp.ui.horoscope

import com.acevedo.horoscapp.data.providers.HoroscopeProvider
import com.acevedo.horoscapp.motherObject.HoroscopeMotherObject
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HoroscopeViewModelTest{

    @MockK
    lateinit var horoscopeProvider: HoroscopeProvider

    private lateinit var viewModel: HoroscopeViewModel
    @Before
    fun setUp(){
        //esto se ejecuta antes de cada test
        MockKAnnotations.init(this, relaxUnitFun = true)

    }

    @Test
    fun `when viewmodel is created then horoscopes are loaded`(){
        //Given
        every { horoscopeProvider.getHoroscopes() } returns HoroscopeMotherObject.horoscopeInfoList
        viewModel = HoroscopeViewModel(horoscopeProvider)

        //When
        val horoscopes = viewModel.horoscope.value

        //Then
        assertTrue(horoscopes.isNotEmpty())

    }
}