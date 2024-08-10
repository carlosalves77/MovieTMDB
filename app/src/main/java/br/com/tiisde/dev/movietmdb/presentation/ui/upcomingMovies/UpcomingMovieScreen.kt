package br.com.tiisde.dev.movietmdb.presentation.ui.upcomingMovies

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.tiisde.dev.movietmdb.util.Result

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

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            when (response) {
                is Result.Success -> {
                    response.data.results.forEach {
                        item {
                            Text(
                                text = it.originalTitle,
                                fontSize = 20.sp,
                                fontFamily = FontFamily.SansSerif
                            )
                        }
                    }
                }

                is Result.Error -> {
                    item {
                        Text(
                            text = "Error",
                            fontSize = 20.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                    }

                }

                is Result.Loading -> {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier.size(100.dp)
                        )
                    }

                }

                else -> {

                }
            }

        }


    }


}