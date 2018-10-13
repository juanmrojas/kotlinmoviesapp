package prodroid.juan.moviesappkotlin.movies.repository

import io.reactivex.disposables.Disposable
import javax.inject.Singleton

@Singleton
class MovieRepository {


    val compositeDisposable: MutableList<Disposable> = arrayListOf()

}