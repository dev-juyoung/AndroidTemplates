package io.cro.android.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "temporary")
data class Temporary(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "entityId") var id: Long = 0L,
    @ColumnInfo(name = "version") var version: String = ""
)
