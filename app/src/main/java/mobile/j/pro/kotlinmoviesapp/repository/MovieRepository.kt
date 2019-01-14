package mobile.j.pro.kotlinmoviesapp.repository

import android.arch.lifecycle.LiveData
import mobile.j.pro.kotlinmoviesapp.AppExecutors
import mobile.j.pro.kotlinmoviesapp.api.MovieService
import mobile.j.pro.kotlinmoviesapp.db.MovieDao
import mobile.j.pro.kotlinmoviesapp.vo.Movie
import mobile.j.pro.kotlinmoviesapp.vo.Movies
import mobile.j.pro.kotlinmoviesapp.vo.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
        private val appExecutors: AppExecutors,
        private val movieDao: MovieDao,
        private val movieService: MovieService
) {

    fun loadMovies(title: String): LiveData<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, Movies>(appExecutors) {
            override fun saveCallResult(item: Movies) {
                movieDao.insert(item.results)
            }

            override fun shouldFetch(data: List<Movie>?) = data == null || data.isEmpty()

            override fun loadFromDb() = movieDao.findByTitle(title)

            override fun createCall() = movieService.getMovies("503695767acad7d3a0bbd347e5293747", title)
        }.asLiveData()
    }
}