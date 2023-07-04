package com.example.myapplication.play

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainAppScopeImpl : AppScope {

    override fun ioScope(): CoroutineScope {
        return CoroutineScope(Dispatchers.IO)
    }

    override fun main(): CoroutineScope {
        return CoroutineScope(Dispatchers.Main)
    }

    override fun cpu(): CoroutineScope {
        return CoroutineScope(Dispatchers.Default)
    }
}