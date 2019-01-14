package mobile.j.pro.kotlinmoviesapp.vo

import android.arch.persistence.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(primaryKeys = ["id"])
data class Movie(
        @field:SerializedName("id")
        val id: Int,
        @field:SerializedName("poster_path")
        val posterPath: String?,
        @field:SerializedName("release_date")
        val releaseDate: String,
        @field:SerializedName("original_title")
        val originalTitle: String,
        @field:SerializedName("title")
        val title: String,
        @field:SerializedName("overview")
        val overview: String,
        @field:SerializedName("original_language")
        val originalLanguage: String,
        /* @field:SerializedName("popularity")
        val popularity: Number, */
        @field:SerializedName("vote_count")
        val voteCount: Int,
        /* @field:SerializedName("vote_average")
         val voteAverage: Number ,*/
        @field:SerializedName("video")
        val video: Boolean,
        @field:SerializedName("adult")
        val adult: Boolean
)