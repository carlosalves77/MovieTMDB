package br.com.tiisde.dev.movietmdb.domain.use_case

import br.com.tiisde.dev.movietmdb.data.dto.PopularMoviesDTO
import br.com.tiisde.dev.movietmdb.data.dto.UpcomingMoviesDTO
import br.com.tiisde.dev.movietmdb.domain.repository.RemoteDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(
    private val repository: RemoteDataRepository
) {

    suspend operator fun invoke(): Flow<Response<UpcomingMoviesDTO>> = flow {
        emit(repository.getUpcomingMovies())
    }.flowOn(Dispatchers.Default)


}