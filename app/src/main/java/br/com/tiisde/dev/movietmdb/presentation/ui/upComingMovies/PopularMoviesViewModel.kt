package br.com.tiisde.dev.movietmdb.presentation.ui.upComingMovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.tiisde.dev.movietmdb.data.dto.toPopularMovies
import br.com.tiisde.dev.movietmdb.domain.model.PopularMovies
import br.com.tiisde.dev.movietmdb.domain.use_case.GetPopularMoviesUseCase
import br.com.tiisde.dev.movietmdb.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel() {


    private val _getPopularMovies = MutableStateFlow<Result<PopularMovies>>(Result.Idle)
    val popularMoviesResponse = _getPopularMovies.asStateFlow()

    fun getPopularMovies() {
        viewModelScope.launch {
            getPopularMoviesUseCase().onStart {
                   _getPopularMovies.value = Result.Loading
            }.catch {
                _getPopularMovies.value = Result.Error(it)
            }.collect {
                _getPopularMovies.value = Result.Success(it.body()!!.toPopularMovies())
            }
        }

    }

}