package com.mahshad.network.model

import com.mahshad.model.data.Object
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ObjectDto(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("data")
    val data: DataDto?,
)

fun ObjectDto.toObject() = Object(
    id = this.id,
    name = this.name,
    data = this.data?.toData()
)