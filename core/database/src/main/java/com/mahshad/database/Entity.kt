package com.mahshad.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mahshad.model.data.Data

@Entity(tableName = "Objects")
data class Entity(
    @PrimaryKey @ColumnInfo(name = "object_id") val id: String,
    @ColumnInfo(name = "object_name") val name: String,
    @Embedded(prefix = "object_") val data: Data?
)