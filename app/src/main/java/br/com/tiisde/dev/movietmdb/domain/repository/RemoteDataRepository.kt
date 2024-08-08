package br.com.tiisde.dev.movietmdb.domain.repository

import br.com.tiisde.dev.movietmdb.data.dto.PopularMoviesDTO
import br.com.tiisde.dev.movietmdb.data.dto.UpcomingMoviesDTO
import retrofit2.Response

interface RemoteDataRepository {

    suspend fun getPopularMovies(): Response<PopularMoviesDTO>

    suspend fun getUpcomingMovies(): Response<UpcomingMoviesDTO>


}