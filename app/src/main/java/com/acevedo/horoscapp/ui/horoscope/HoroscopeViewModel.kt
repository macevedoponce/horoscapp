package com.acevedo.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.acevedo.horoscapp.data.providers.HoroscopeProvider
import com.acevedo.horoscapp.domain.model.HoroscopeInfo
import com.acevedo.horoscapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider):ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope:StateFlow<List<HoroscopeInfo>> = _horoscope

    init{
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }


}