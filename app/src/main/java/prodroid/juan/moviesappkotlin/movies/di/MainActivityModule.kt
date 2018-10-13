package prodroid.juan.moviesappkotlin.movies.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import prodroid.juan.moviesappkotlin.movies.MoviesActivity

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [FragmentBuilderModule::class])
    abstract fun contributeMoviesActivity(): MoviesActivity
}