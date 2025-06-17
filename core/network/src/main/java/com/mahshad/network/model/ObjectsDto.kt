package com.mahshad.network.model

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

@Serializable
data class DataDto(
    @SerialName("Generation")
    val generation: String?,
    @SerialName("Price")
    val price: String?,
    @SerialName("Capacity")
    val capacity: String?,
    @SerialName("Screen size")
    val screenSize: Double?,
    @SerialName("Color")
    val color: String?,
    @SerialName("Description")
    val description: String?,
    @SerialName("Strap Colour")
    val strapColour: String?,
    @SerialName("Case Size")
    val caseSize: String?,
    val year: Long?,
    @SerialName("price")
    val price2: Double?,
    @SerialName("CPU model")
    val cpuModel: String?,
    @SerialName("Hard disk size")
    val hardDiskSize: String?,
    @SerialName("generation")
    val generation2: String?,
    @SerialName("color")
    val color2: String?,
    @SerialName("capacity GB")
    val capacityGb: Long?,
    @SerialName("capacity")
    val capacity2: String?,
)

