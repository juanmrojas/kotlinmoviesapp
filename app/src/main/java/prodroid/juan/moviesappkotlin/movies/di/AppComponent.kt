package prodroid.juan.moviesappkotlin.movies.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import prodroid.juan.moviesappkotlin.movies.MoviesApp
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    MainActivityModule::class])

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(moviesApp: MoviesApp)
}