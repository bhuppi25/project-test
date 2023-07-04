package com.example.myapplication.play.data.repo

import android.content.Context
import com.example.myapplication.play.data.model.Quiz
import com.google.gson.Gson

class LocalDataSource(private val context: Context, val gson: Gson) :
    DataSource<String, List<Quiz>> {

    override fun load(input: String): List<Quiz> {
        val quizData = context.assets.open(input).bufferedReader().use {
            it.readText()
        }
        return gson.fromJson(quizData, List::class.java) as List<Quiz>
    }
}