package com.example.myapplication.play.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.play.data.model.Quiz
import com.example.myapplication.play.data.repo.QuizDatRepo
import com.example.myapplication.play.usecase.QuizUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val quizDatRepo: QuizDatRepo,
    private val quizUseCase: QuizUseCase
) : ViewModel() {


    private val quizData = mutableListOf<Quiz>()
    private var quizIndex = 0

    private val _quizLiveData = MutableLiveData<Quiz>()
    val quizLiveData: LiveData<Quiz>
        get() = _quizLiveData

    private val _quizValidationLiveData = MutableLiveData<Boolean>()
    val quizValidationLiveData: LiveData<Boolean>
        get() = _quizValidationLiveData

    fun start() {
        subscribeToQuizData()
    }

    private fun subscribeToQuizData() {
        viewModelScope.launch {
            quizDatRepo.dataSource.collect {
                quizData.addAll(it)
                _quizLiveData.postValue(quizData[quizIndex])
            }
        }
    }

    fun loadData(input: String) {
        viewModelScope.launch {
            quizDatRepo.loadData(input)
        }
    }

    fun onQuestionChange(index: Int) {
        if (index + 1 < quizData.size) {
            quizIndex += 1
            _quizLiveData.postValue(quizData[quizIndex])
        }
    }

    fun onSubmit(userInput: String) {
        _quizValidationLiveData.postValue(quizData[quizIndex].answer == userInput)
    }
}