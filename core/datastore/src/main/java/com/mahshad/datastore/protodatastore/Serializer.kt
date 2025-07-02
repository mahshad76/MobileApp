//package com.mahshad.model.proto
//
//
//import androidx.datastore.core.CorruptionException
//import androidx.datastore.core.Serializer
//import com.google.protobuf.InvalidProtocolBufferException
//import main.proto.UserProfile
//import java.io.InputStream
//import java.io.OutputStream
//
//class UserPreferencesSerializer : Serializer<UserProfile> {
//    override val defaultValue: UserProfile = UserProfile.getDefaultInstance()
//
//    @Suppress("BlockingMethodInNonBlockingContext")
//    override suspend fun readFrom(input: InputStream): UserProfile {
//        try {
//            return UserProfile.parseFrom(input)
//        } catch (exception: InvalidProtocolBufferException) {
//            throw CorruptionException("Cannot read proto.", exception)
//        }
//    }
//
//    @Suppress("BlockingMethodInNonBlockingContext")
//    override suspend fun writeTo(t: UserProfile, output: OutputStream) =
//        t.writeTo(output)
//}