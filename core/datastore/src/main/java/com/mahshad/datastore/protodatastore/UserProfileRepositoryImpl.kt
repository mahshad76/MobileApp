package com.mahshad.datastore.protodatastore

import com.mahshad.datastore.Address
import com.mahshad.datastore.UserProfile
import com.mahshad.datastore.UserProfileSerializer
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

// Define the DataStore instance at the top level of the file for singleton access
val Context.userProfileDataStore: DataStore<UserProfile> by dataStore(
    fileName = "user_prefs.pb", // Recommended extension for Proto DataStore
    serializer = UserProfileSerializer
)

// 2. Implement the repository interface
class UserProfileRepositoryImpl @Inject constructor(
    private val applicationContext: Context // Inject Application Context
) : UserProfileRepository {

    // Expose the DataStore's data Flow directly
    override val userProfileFlow: Flow<UserProfile> = applicationContext.userProfileDataStore.data
        .map { userProfile ->
            // You can perform any transformations here if needed,
            // but often you'll return the proto object directly.
            userProfile
        }

    // Implement the update methods using DataStore's updateData
    override suspend fun updateName(name: String) {
        applicationContext.userProfileDataStore.updateData { currentProfile ->
            currentProfile.toBuilder() // Use the generated toBuilder() method
                .setName(name)
                .build() // Build a new immutable instance
        }
    }

    override suspend fun updateAge(age: Int) {
        applicationContext.userProfileDataStore.updateData { currentProfile ->
            currentProfile.toBuilder()
                .setAge(age)
                .build()
        }
    }

    override suspend fun updateAddress(street: String, city: String, country: String) {
        applicationContext.userProfileDataStore.updateData { currentProfile ->
            currentProfile.toBuilder()
                .setAddress(
                    Address.newBuilder() // Assuming Address is also a generated proto message
                        .setStreet(street)
                        .setCity(city)
                        .setCountry(country)
                        .build()
                )
                .build()
        }
    }

    override suspend fun clearUserProfile() {
        applicationContext.userProfileDataStore.updateData {
            UserProfile.getDefaultInstance() // Reset to default values defined in proto
        }
    }
}
