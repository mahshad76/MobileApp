package com.mahshad.model.data

data class Data(
    val generation: String?,
    val price: String?,
    val capacity: String?,
    val screenSize: Double?,
    val color: String?,
    val description: String?,
    val strapColour: String?,
    val caseSize: String?,
    val year: Long?,
    val price2: Double?,
    val cpuModel: String?,
    val hardDiskSize: String?,
    val generation2: String?,
    val color2: String?,
    val capacityGb: Long?,
    val capacity2: String?,
) {
    companion object {
        val DEFAULT = Data(
            "third",
            "700",
            "20GB",
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )
    }
}
