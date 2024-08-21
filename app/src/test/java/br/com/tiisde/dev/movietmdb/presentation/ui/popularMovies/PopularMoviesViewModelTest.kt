package br.com.tiisde.dev.movietmdb.presentation.ui.popularMovies

import br.com.tiisde.dev.movietmdb.domain.use_case.GetPopularMoviesUseCase
import br.com.tiisde.dev.movietmdb.util.Result
import io.mockk.coEvery
import io.mockk.mockk

import org.junit.jupiter.api.Test

class PopularMoviesViewModelTest {


    private val getPopularMoviesUseCase : GetPopularMoviesUseCase = mockk{
        coEvery {

        }
    }
    private val viewModel = PopularMoviesViewModel(getPopularMoviesUseCase)



    @Test
    fun `When fetching movies, should return a list of movies`() {
      viewModel.popularMoviesResponse
        assert(viewModel.popularMoviesResponse.value is Result.Success)
    }

    @Test
    fun getPopularMovies() {
    }
}