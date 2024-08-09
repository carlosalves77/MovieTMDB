package br.com.tiisde.dev.movietmdb.presentation.ui.upcomingMovies

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UpcomingMoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: UpcomingMoviesViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true, block = {
    viewModel.getUpcomingMovies()
    })

   val response = viewModel.upcomingMoviesResponse.collectAsState().value

    Log.d("upcomingMoviesScreen", "PopularMoviesScreen: $response")




}