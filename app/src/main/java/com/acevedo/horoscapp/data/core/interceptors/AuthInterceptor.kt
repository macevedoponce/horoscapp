package com.acevedo.horoscapp.data.core.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager) :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
                      .newBuilder()
                      .header("Autorization",tokenManager.getToken())
                      .build()//petición que llega al servidor, que se vuelve a crear con algo nuevo
        return chain.proceed(request)

    }
}

class TokenManager @Inject constructor(){
    fun getToken():String = "EL TOKEN QUE SE OBTIENE DE BD"
}