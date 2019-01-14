package mobile.j.pro.kotlinmoviesapp.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mobile.j.pro.kotlinmoviesapp.ui.movies.MoviesViewModel
import mobile.j.pro.kotlinmoviesapp.viewmodel.MoviesViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindMoviesViewModel(moviesViewModel: MoviesViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: MoviesViewModelFactory): ViewModelProvider.Factory
}