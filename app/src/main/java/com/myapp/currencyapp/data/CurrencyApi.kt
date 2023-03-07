package com.myapp.currencyapp.data

import com.myapp.currencyapp.constants.Constants.API_KEY
import com.myapp.currencyapp.data.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CurrencyApi {
    @GET("/latest")
    @Headers("apikey",API_KEY)
    suspend fun getRates(@Query("base") base:String ):Response<CurrencyResponse>

}