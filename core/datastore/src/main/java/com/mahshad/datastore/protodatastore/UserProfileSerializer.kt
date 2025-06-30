package com.mahshad.datastore.protodatastore

import androidx.datastore.core.Serializer
import com.mahshad.model.proto.UserProfile
import java.io.InputStream
import java.io.OutputStream

object UserProfileSerializer : Serializer<UserProfile> {
    override val defaultValue: UserProfile
        get() = TODO("Not yet implemented")

    override suspend fun readFrom(input: InputStream): UserProfile {
        TODO("Not yet implemented")
    }

    override suspend fun writeTo(t: UserProfile, output: OutputStream) {
        TODO("Not yet implemented")
    }
}