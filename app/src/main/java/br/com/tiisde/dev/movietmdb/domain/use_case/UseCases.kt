package br.com.tiisde.dev.movietmdb.domain.use_case

import br.com.tiisde.dev.movietmdb.domain.repository.RemoteDataRepository
import javax.inject.Inject

data class UseCases (
     val getPopularMoviesUseCase : GetPopularMoviesUseCase,
     val getUpcomingMoviesUseCase:  GetUpcomingMoviesUseCase
)



