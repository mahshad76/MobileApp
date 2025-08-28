package com.mahshad.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

fun <T> Flow<T>.throttleFirst(durationMillis: Long): Flow<T> {
    require(durationMillis > 0) { "Duration must be positive" }
    var lastEmissionTime = 0L
    return this.onEach {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastEmissionTime >= durationMillis) {
            lastEmissionTime = currentTime
        } else {
        }
    }
}