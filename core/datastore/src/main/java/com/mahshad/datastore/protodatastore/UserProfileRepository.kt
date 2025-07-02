package com.mahshad.datastore.protodatastore

import com.mahshad.datastore.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {

    /**
     * A [Flow] that emits the current [UserProfile] data whenever it changes.
     *
     * Collectors of this flow will receive the latest user profile state,
     * including initial values (which will be [UserProfile.getDefaultInstance]
     * if no data has been saved yet or if the stored data is corrupted).
     *
     * This allows for reactive UI updates or data synchronization.
     */
    val userProfileFlow: Flow<UserProfile>

    /**
     * Atomically updates the user's name in the stored [UserProfile].
     *
     * This operation is transactional. If the update fails (e.g., due to an I/O error
     * or concurrent modification), the data will revert to its previous consistent state.
     *
     * @param name The new name to set for the user profile. Cannot be null.
     */
    suspend fun updateName(name: String)

    /**
     * Atomically updates the user's age in the stored [UserProfile].
     *
     * This operation is transactional. If the update fails (e.g., due to an I/O error
     * or concurrent modification), the data will revert to its previous consistent state.
     *
     * @param age The new age to set for the user profile.
     */
    suspend fun updateAge(age: Int)

    /**
     * Atomically updates the user's address details (street, city, country)
     * in the stored [UserProfile].
     *
     * This operation is transactional. All three address components are updated
     * together. If the update fails, the address data will revert to its previous
     * consistent state.
     *
     * @param street The new street address.
     * @param city The new city.
     * @param country The new country.
     */
    suspend fun updateAddress(street: String, city: String, country: String)

    /**
     * Clears all stored user profile data, reverting it to its default state.
     *
     * This operation effectively sets the [UserProfile] back to
     * [UserProfile.getDefaultInstance()]. This is typically used for logout
     * or resetting user-specific data.
     */
    suspend fun clearUserProfile()
}