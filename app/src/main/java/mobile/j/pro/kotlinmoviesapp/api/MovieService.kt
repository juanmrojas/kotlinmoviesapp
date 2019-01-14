package mobile.j.pro.kotlinmoviesapp.api

import android.arch.lifecycle.LiveData
import mobile.j.pro.kotlinmoviesapp.vo.Movie
import mobile.j.pro.kotlinmoviesapp.vo.Movies
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("search/movie")
    fun getMovies(
            @Query("api_key") apiKey: String,
            @Query("query") query: String): LiveData<ApiResponse<Movies>>
}