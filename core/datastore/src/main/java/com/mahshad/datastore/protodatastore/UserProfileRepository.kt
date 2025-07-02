package com.mahshad.datastore.protodatastore

import com.mahshad.datastore.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {
    // Expose the UserProfile data as a Flow for observing changes
    val userProfileFlow: Flow<UserProfile>

    // Methods to update specific fields in the UserProfile
    suspend fun updateName(name: String)
    suspend fun updateAge(age: Int)
    suspend fun updateAddress(street: String, city: String, country: String)
    suspend fun clearUserProfile() // Example: to reset data
}