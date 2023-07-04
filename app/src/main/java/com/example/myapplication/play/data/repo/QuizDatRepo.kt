package com.example.myapplication.play.data.repo

import com.example.myapplication.play.data.model.Quiz
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class QuizDatRepo(
    private val localDataSource: DataSource<String, List<Quiz>>,
    private val ioScope: CoroutineScope
) {
    private val _dataSource = MutableSharedFlow<List<Quiz>>()
    val dataSource: Flow<List<Quiz>>
        get() = _dataSource


    fun loadData(input: String) {
        ioScope.launch {
            _dataSource.emit(localDataSource.load(input))
        }
    }
}