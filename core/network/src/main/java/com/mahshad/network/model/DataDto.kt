package com.mahshad.network.model

import com.mahshad.model.data.Data
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DataDto(
    @SerialName("Generation")
    val generation: String? = null,
    @SerialName("Price")
    val price: String? = null,
    @SerialName("Capacity")
    val capacity: String? = null,
    @SerialName("Screen size")
    val screenSize: Double? = null,
    @SerialName("Color")
    val color: String? = null,
    @SerialName("Description")
    val description: String? = null,
    @SerialName("Strap Colour")
    val strapColour: String? = null,
    @SerialName("Case Size")
    val caseSize: String? = null,
    val year: Long? = null,
    @SerialName("price")
    val price2: Double? = null,
    @SerialName("CPU model")
    val cpuModel: String? = null,
    @SerialName("Hard disk size")
    val hardDiskSize: String? = null,
    @SerialName("generation")
    val generation2: String? = null,
    @SerialName("color")
    val color2: String? = null,
    @SerialName("capacity GB")
    val capacityGb: Long? = null,
    @SerialName("capacity")
    val capacity2: String? = null,
)

fun DataDto.toData() = Data(
    generation = this.generation,
    price = when (this.price) {
        null, "", " " -> "unknown"
        else -> this.price
    },
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