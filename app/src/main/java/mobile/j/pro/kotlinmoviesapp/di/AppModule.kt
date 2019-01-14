package mobile.j.pro.kotlinmoviesapp.di

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import mobile.j.pro.kotlinmoviesapp.api.MovieService
import mobile.j.pro.kotlinmoviesapp.db.MovieDao
import mobile.j.pro.kotlinmoviesapp.db.MoviesDb
import mobile.j.pro.kotlinmoviesapp.util.LiveDataCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideMovieService(): MovieService {
        return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                .build()
                .create(MovieService::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): MoviesDb {
        return Room
                .databaseBuilder(app, MoviesDb::class.java, "movies.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(db: MoviesDb): MovieDao {
        return db.movieDao()
    }
}