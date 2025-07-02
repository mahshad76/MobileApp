package com.mahshad.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore

val Context.userProfileDataStore: DataStore<UserProfile> by dataStore(
    fileName = "user_profile.pb",
    serializer = UserProfileSerializer
)