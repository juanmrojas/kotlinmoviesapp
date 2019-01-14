package mobile.j.pro.kotlinmoviesapp.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import mobile.j.pro.kotlinmoviesapp.vo.Movie

@Database(
        entities = [
            Movie::class
        ],
        version = 1,
        exportSchema = false
)
abstract class MoviesDb : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}