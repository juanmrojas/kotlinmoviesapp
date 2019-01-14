package mobile.j.pro.kotlinmoviesapp.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import mobile.j.pro.kotlinmoviesapp.vo.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movies: List<Movie>)

    @Query("SELECT * FROM movie WHERE title LIKE '%' || :title  || '%'")
    fun findByTitle(title: String): LiveData<List<Movie>>
}