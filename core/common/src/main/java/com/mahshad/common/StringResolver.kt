package com.mahshad.common

import androidx.annotation.StringRes

interface StringResolver {
    fun getString(@StringRes resourceId: Int): String
}