package com.mahshad.model.data

data class Object(
    val id: String?,
    val name: String?,
    val data: Data?,
) {
    companion object {
        val DEFAULT = Object(
            "1",
            "galaxy",
            Data.DEFAULT
        )
    }
}
