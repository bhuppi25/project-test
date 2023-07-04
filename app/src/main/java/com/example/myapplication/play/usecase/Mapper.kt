package com.example.myapplication.play.usecase

interface UseCase<I, O> {
    fun execute(input: I): O
}