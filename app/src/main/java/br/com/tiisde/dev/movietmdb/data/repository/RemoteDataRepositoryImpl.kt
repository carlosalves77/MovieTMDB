package br.com.tiisde.dev.movietmdb.data.repository

import br.com.tiisde.dev.movietmdb.data.MovieTMDBApi
import br.com.tiisde.dev.movietmdb.data.dto.PopularMoviesDTO
import br.com.tiisde.dev.movietmdb.data.dto.UpcomingMoviesDTO
import br.com.tiisde.dev.movietmdb.domain.repository.RemoteDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class RemoteDataRepositoryImpl @Inject constructor(
    private val api: MovieTMDBApi
): RemoteDataRepository {
    override suspend fun getPopularMovies(): Response<PopularMoviesDTO> {
        return withContext(Dispatchers.Default) {
            api.getPopularMovies()
        }
    }

    override suspend fun getUpcomingMovies(): Response<UpcomingMoviesDTO> {
      return withContext(Dispatchers.Default) {
          api.getUpcomingMovies()
      }
    }


}