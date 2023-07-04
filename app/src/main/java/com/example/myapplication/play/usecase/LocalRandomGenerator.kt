package com.example.myapplication.play.usecase

import java.util.*

class LocalRandomGenerator : RandomGenerator {
    private val random by lazy {
        Random()
    }

    override fun generate(input: String): String {
        val map = mutableMapOf<Int, Int>()
        var start = 0
        while (start < input.length) {
            val nextInt = random.nextInt(input.length)
            if (!map.containsKey(nextInt)) {
                map.put(start, nextInt)
                start++
            }
        }
        val charArray = CharArray(input.length)
        map.entries.forEach {
            charArray[it.key] = input.toCharArray()[it.value]
        }
        return charArray.toString()
    }
}