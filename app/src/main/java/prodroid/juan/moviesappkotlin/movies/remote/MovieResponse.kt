package prodroid.juan.moviesappkotlin.movies.remote

import com.google.gson.annotations.SerializedName
import prodroid.juan.moviesappkotlin.movies.domain.Movie

data class MovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<Movie>,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int)