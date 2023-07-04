package com.example.myapplication.play.data.repo

interface DataSource<I : Any, O : Any> {
    fun load(input: I): O
}