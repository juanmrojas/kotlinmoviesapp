package prodroid.juan.moviesappkotlin.movies.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import prodroid.juan.moviesappkotlin.movies.ui.SearchViewModel
import prodroid.juan.moviesappkotlin.movies.viewmodel.MoviesViewModelFactory

@Suppress("unused")
@Module
abstract class ViewModelModule {

    /* Here is the section where we are going to define all view models
     that will be injected */

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: MoviesViewModelFactory): ViewModelProvider.Factory
}