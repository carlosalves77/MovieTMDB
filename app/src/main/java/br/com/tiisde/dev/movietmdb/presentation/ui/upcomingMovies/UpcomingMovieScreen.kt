package br.com.tiisde.dev.movietmdb.presentation.ui.upcomingMovies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.tiisde.dev.movietmdb.presentation.ui.upcomingMovies.components.ListOfUpcomingMovies
import br.com.tiisde.dev.movietmdb.util.Result

@Composable
fun UpcomingMoviesScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    viewModel: UpcomingMoviesViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true, block = {
        viewModel.getUpcomingMovies()
    })

    val response = viewModel.upcomingMoviesResponse.collectAsStateWithLifecycle().value

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = modifier.size(10.dp))

            when (response) {
                is Result.Success -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        LazyVerticalStaggeredGrid(
                            columns = StaggeredGridCells.Fixed(2),
                            verticalItemSpacing = 4.dp,
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                            content = {
                                items(response.data.results) { result ->
                                    ListOfUpcomingMovies(result)
                                }
                            },

                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                }

                is Result.Error -> {
                    Text(
                        text = "Error",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif
                    )

                }

                is Result.Loading -> {

                    CircularProgressIndicator(
                        modifier = Modifier.size(100.dp)
                    )
                }

                else -> {

                }
            }


        }



}








