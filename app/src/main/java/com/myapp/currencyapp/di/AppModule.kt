package com.myapp.currencyapp.di

import com.myapp.currencyapp.constants.Constants
import com.myapp.currencyapp.data.CurrencyApi
import com.myapp.currencyapp.main.DefaultMainRepository
import com.myapp.currencyapp.main.MainRepository
import com.myapp.currencyapp.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideCurrencyApi(): CurrencyApi = Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build().create(CurrencyApi::class.java)


    @Singleton
    @Provides
    fun provideMainRepository(api: CurrencyApi):MainRepository= DefaultMainRepository(api)

    @Singleton
    @Provides
    fun provideDispatcher():DispatcherProvider=object :DispatcherProvider{
        override val defaultDispatcher: CoroutineDispatcher
            get() = Dispatchers.Main
        override val main: CoroutineDispatcher
            get() = Dispatchers.IO
        override val io: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }
}