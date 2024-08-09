package br.com.tiisde.dev.movietmdb.di

import br.com.tiisde.dev.movietmdb.data.MovieTMDBApi
import br.com.tiisde.dev.movietmdb.data.repository.RemoteDataRepositoryImpl
import br.com.tiisde.dev.movietmdb.domain.repository.RemoteDataRepository
import br.com.tiisde.dev.movietmdb.domain.use_case.GetPopularMoviesUseCase
import br.com.tiisde.dev.movietmdb.domain.use_case.GetUpcomingMoviesUseCase
import br.com.tiisde.dev.movietmdb.domain.use_case.UseCases
import br.com.tiisde.dev.movietmdb.util.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi() : Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


    @Provides
    @Singleton
    fun provideMoviesTMDB(moshi: Moshi) : MovieTMDBApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MovieTMDBApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieTMDBApi): RemoteDataRepository {
        return RemoteDataRepositoryImpl(api)
    }

  @Provides
  @Singleton
  fun provideUseCases(repository: RemoteDataRepository): UseCases {
      return UseCases(
          getPopularMoviesUseCase = GetPopularMoviesUseCase(repository),
          getUpcomingMoviesUseCase = GetUpcomingMoviesUseCase(repository)
      )

  }





}