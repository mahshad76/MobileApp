package com.mahshad.network.model

import com.mahshad.model.data.Data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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

fun DataDto.toData() = Data(
    generation = this.generation,
    price = this.price,
    capacity = this.capacity,
    screenSize = this.screenSize,
    color = this.color,
    description = this.description,
    strapColour = this.strapColour,
    caseSize = this.caseSize,
    year = this.year,
    price2 = this.price2,
    cpuModel = this.cpuModel,
    hardDiskSize = this.hardDiskSize,
    generation2 = this.generation2,
    color2 = this.color2,
    capacityGb = this.capacityGb,
    capacity2 = this.capacity2,
)