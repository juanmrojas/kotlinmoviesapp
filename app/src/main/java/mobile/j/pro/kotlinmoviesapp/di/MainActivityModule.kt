package mobile.j.pro.kotlinmoviesapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mobile.j.pro.kotlinmoviesapp.ui.movies.MoviesActivity

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun contribuitesMoviesActivity(): MoviesActivity
}