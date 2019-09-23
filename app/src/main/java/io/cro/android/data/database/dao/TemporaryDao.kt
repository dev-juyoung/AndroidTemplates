package io.cro.android.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import io.cro.android.data.database.entity.Temporary
import io.reactivex.Single

@Dao
interface TemporaryDao {
    @Query("SELECT * FROM `temporary`")
    fun getTemporaries(): Single<List<Temporary>>
}
