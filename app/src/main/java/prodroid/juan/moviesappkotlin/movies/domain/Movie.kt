package prodroid.juan.moviesappkotlin.movies.domain

import com.google.gson.annotations.SerializedName

data class Movie(
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("adult") val adult: Boolean,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: String,
        @SerializedName("id") val id: Int,
        @SerializedName("original_title") val originalTitle: String,
        @SerializedName("original_language") val originalLanguage: String,
        @SerializedName("title") val title: String,
        @SerializedName("popularity") val popularity: Number,
        @SerializedName("vote_count") val voteCount: Int,
        @SerializedName("video") val video: Boolean,
        @SerializedName("vote_average") val voteAverage: Number)