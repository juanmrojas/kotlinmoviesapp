package mobile.j.pro.kotlinmoviesapp.ui.movies

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import mobile.j.pro.kotlinmoviesapp.repository.MovieRepository
import mobile.j.pro.kotlinmoviesapp.util.AbsentLiveData
import mobile.j.pro.kotlinmoviesapp.vo.Movie
import mobile.j.pro.kotlinmoviesapp.vo.Resource
import java.util.*
import javax.inject.Inject

class MoviesViewModel @Inject constructor(movieRepository: MovieRepository) : ViewModel() {

    // switchMap will retransmit any value associated with the query variable

    private val query = MutableLiveData<String>()
    val results: LiveData<Resource<List<Movie>>> = Transformations
            .switchMap(query) { search ->
                if(search.isNullOrBlank()) {
                    AbsentLiveData.create()
                } else {
                    movieRepository.loadMovies(search)
                }
    }

    fun setQuery(title: String) {
        val input = title.toLowerCase(Locale.getDefault()).trim()
        if(input == query.value) {
            return
        }
        query.value = input
    }
}