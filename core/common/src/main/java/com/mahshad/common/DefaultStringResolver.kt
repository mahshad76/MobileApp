package com.mahshad.common

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DefaultStringResolver @Inject constructor(@ApplicationContext private val context: Context) :
    StringResolver {
    override fun getString(@StringRes resourceId: Int): String {
        return context.resources.getString(resourceId)
    }
}
