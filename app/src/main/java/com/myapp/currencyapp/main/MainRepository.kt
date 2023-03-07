package com.myapp.currencyapp.main

import com.myapp.currencyapp.data.models.CurrencyResponse
import com.myapp.currencyapp.util.Resource

interface MainRepository {
    suspend fun getRates(base:String):Resource<CurrencyResponse>
}