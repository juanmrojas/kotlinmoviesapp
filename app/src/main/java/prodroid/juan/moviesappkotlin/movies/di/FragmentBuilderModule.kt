package prodroid.juan.moviesappkotlin.movies.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import prodroid.juan.moviesappkotlin.movies.ui.SearchFragment

@Suppress("unused")
@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}