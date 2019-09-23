package io.cro.android.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.cro.android.data.database.dao.TemporaryDao
import io.cro.android.data.database.entity.Temporary
import io.cro.android.util.DATABASE_VERSION

@Database(
    version = DATABASE_VERSION,
    exportSchema = false,
    entities = [Temporary::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun temporaryDao(): TemporaryDao
}
