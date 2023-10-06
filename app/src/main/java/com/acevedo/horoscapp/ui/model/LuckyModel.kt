package com.acevedo.horoscapp.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LuckyModel (
    //drawableres, stringres es para asegurarse de que cuando llamen a esa clase se asegure que se mande un drawable, string
    @DrawableRes val image:Int,
    @StringRes val text:Int
)