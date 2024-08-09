package br.com.tiisde.dev.movietmdb.presentation.ui.popularMovies

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PopularMoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: PopularMoviesViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true, block = {
    viewModel.getPopularMovies()
    })

   val response = viewModel.popularMoviesResponse.collectAsState().value

    Log.d("PopularMoviesScreen", "PopularMoviesScreen: $response")




}