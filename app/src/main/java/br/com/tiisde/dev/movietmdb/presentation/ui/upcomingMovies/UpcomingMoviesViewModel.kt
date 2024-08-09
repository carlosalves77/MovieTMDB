package br.com.tiisde.dev.movietmdb.presentation.ui.upcomingMovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.tiisde.dev.movietmdb.data.dto.toPopularMovies
import br.com.tiisde.dev.movietmdb.data.dto.toUpcomingMovies
import br.com.tiisde.dev.movietmdb.domain.model.UpcomingMovies
import br.com.tiisde.dev.movietmdb.domain.use_case.GetUpcomingMoviesUseCase
import br.com.tiisde.dev.movietmdb.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpcomingMoviesViewModel @Inject constructor(
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
): ViewModel() {


    private val _getUpcomingMovies = MutableStateFlow<Result<UpcomingMovies>>(Result.Idle)
    val upcomingMoviesResponse = _getUpcomingMovies.asStateFlow()

    fun getUpcomingMovies() {
        viewModelScope.launch {
            getUpcomingMoviesUseCase().onStart {
                   _getUpcomingMovies.value = Result.Loading
            }.catch {
                _getUpcomingMovies.value = Result.Error(it)
            }.collect {
                _getUpcomingMovies.value = Result.Success(it.body()!!.toUpcomingMovies())
            }
        }

    }

}