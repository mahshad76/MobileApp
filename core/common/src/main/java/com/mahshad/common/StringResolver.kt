package com.mahshad.common

import android.content.Context
import androidx.annotation.StringRes

class StringResolver(private val context: Context) {
    fun getString(@StringRes resourceId: Int): String {
        return context.getString(resourceId)
    }
}