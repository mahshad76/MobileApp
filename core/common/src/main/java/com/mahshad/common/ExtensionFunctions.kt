package com.mahshad.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

fun <T> MutableStateFlow<T?>.throttleFirst(durationMillis: Long): Flow<T?> {
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

fun <T> LiveData<T>.getOrAwaitValues(
    count: Int,
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS
): List<T> {
    val data = mutableListOf<T>()
    val latch = CountDownLatch(count)
    val observer = object : Observer<T> {
        override fun onChanged(o: T) {
            data.add(o)
            latch.countDown()
            if (latch.count == 0L) {
                removeObserver(this)
            }
        }
    }
    observeForever(observer)
    if (!latch.await(time, timeUnit)) {
        removeObserver(observer)
        throw Throwable("LiveData did not emit enough values.")
    }
    return data
}
