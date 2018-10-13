package prodroid.juan.moviesappkotlin.movies.remote

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteMoviesService {

    @GET(RemoteContract.GET_MOVIES_BY_NAME)
    fun requestMoviesByName(
            @Query("api_key") apiKey: String,
            @Query("query") query: String): Observable<MovieResponse>

}