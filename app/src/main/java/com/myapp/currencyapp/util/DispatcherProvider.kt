package com.myapp.currencyapp.util

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val defaultDispatcher: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}