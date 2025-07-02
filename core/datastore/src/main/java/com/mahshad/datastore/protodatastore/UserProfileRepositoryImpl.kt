package com.mahshad.datastore.protodatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.mahshad.datastore.Address
import com.mahshad.datastore.UserProfile
import com.mahshad.datastore.UserProfileSerializer
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserProfileRepositoryImpl @Inject constructor(
    @ApplicationContext
    private val applicationContext: Context
) : UserProfileRepository {

    val Context.userProfileDataStore: DataStore<UserProfile> by dataStore(
        fileName = "user_profile.pb",
        serializer = UserProfileSerializer
    )

    override val userProfileFlow: Flow<UserProfile> = applicationContext.userProfileDataStore.data
        .map { userProfile: UserProfile ->
            // You can perform any transformations here if needed,
            userProfile
        }

    override suspend fun updateName(name: String) {
        applicationContext.userProfileDataStore.updateData { currentProfile: UserProfile ->
            currentProfile.toBuilder()
                .setName(name)
                .build()
        }
    }

    override suspend fun updateAge(age: Int) {
        applicationContext.userProfileDataStore.updateData { currentProfile: UserProfile ->
            currentProfile.toBuilder()
                .setAge(age)
                .build()
        }
    }

    override suspend fun updateAddress(street: String, city: String, country: String) {
        applicationContext.userProfileDataStore.updateData { currentProfile: UserProfile ->
            currentProfile.toBuilder()
                .setAddress(
                    Address.newBuilder()
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
            UserProfile.getDefaultInstance()
        }
    }
}
