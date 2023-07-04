package com.example.myapplication.play

import kotlinx.coroutines.CoroutineScope

interface AppScope {

    fun ioScope(): CoroutineScope
    fun main(): CoroutineScope
    fun cpu(): CoroutineScope
}