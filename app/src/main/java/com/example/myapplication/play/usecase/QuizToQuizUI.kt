package com.example.myapplication.play.usecase

import com.example.myapplication.play.data.model.Quiz
import com.example.myapplication.play.ui.model.QuizUI

class QuizUseCase(private val randomizer: RandomGenerator) : UseCase<Quiz, QuizUI> {

    override fun execute(input: Quiz): QuizUI {
        val randomizedString = randomizer.generate(input.answer)
        return QuizUI(
            input.answer,
            input.url,
            randomizedString
        )
    }
}