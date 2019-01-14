package mobile.j.pro.kotlinmoviesapp.vo

import com.google.gson.annotations.SerializedName

data class Movies(
        @field:SerializedName("page")
        val page: Int,
        @field:SerializedName("results")
        val results: List<Movie>,
        @field:SerializedName("total_pages")
        val totalPages: Int,
        @field:SerializedName("total_results")
        val totalResults: Int
)