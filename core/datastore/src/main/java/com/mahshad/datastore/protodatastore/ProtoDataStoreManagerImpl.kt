package com.mahshad.datastore.protodatastore

import androidx.datastore.core.DataStore
import com.mahshad.core.datastore.Address
import com.mahshad.core.datastore.UserProfile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProtoDataStoreManagerImpl @Inject constructor(
    private val protoDataStore: DataStore<UserProfile>
) : ProtoDataStoreManager {

    override val userProfileFlow: Flow<UserProfile> = protoDataStore.data
        .map { userProfile: UserProfile ->
            // You can perform any transformations here if needed,
            userProfile
        }

    override suspend fun updateName(name: String) {
        protoDataStore.updateData { currentProfile: UserProfile ->
            currentProfile.toBuilder()
                .setName(name)
                .build()
        }
    }

    override suspend fun updateAge(age: Int) {
        protoDataStore.updateData { currentProfile: UserProfile ->
            currentProfile.toBuilder()
                .setAge(age)
                .build()
        }
    }

    override suspend fun updateAddress(street: String, city: String, country: String) {
        protoDataStore.updateData { currentProfile: UserProfile ->
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
        protoDataStore.updateData {
            UserProfile.getDefaultInstance()
        }
    }
}