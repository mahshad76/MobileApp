package com.mahshad.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mahshad.model.data.Data
import com.mahshad.model.data.Object

@Entity(tableName = "Objects")
data class ObjectEntity(
    @PrimaryKey @ColumnInfo(name = "object_id") val id: String,
    @ColumnInfo(name = "object_name") val name: String,
    @Embedded(prefix = "object_") val data: Data?
) {
    companion object {
        val DEFAULT = ObjectEntity(
            "1",
            "galaxy",
            Data.DEFAULT
        )
    }
}

fun ObjectEntity.toObject() = Object(
    name = this.name,
    id = this.id,
    data = this.data
)
