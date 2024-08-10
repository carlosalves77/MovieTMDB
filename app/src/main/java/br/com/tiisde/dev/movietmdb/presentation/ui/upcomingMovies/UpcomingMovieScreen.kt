package br.com.tiisde.dev.movietmdb.presentation.ui.upcomingMovies

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.tiisde.dev.movietmdb.data.dto.ResultX
import br.com.tiisde.dev.movietmdb.util.Constants
import br.com.tiisde.dev.movietmdb.util.Result
import coil.compose.AsyncImage
import coil.request.ImageRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpcomingMoviesScreen(
    modifier: Modifier = Modifier,
    viewModel: UpcomingMoviesViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true, block = {
        viewModel.getUpcomingMovies()
    })

    val response = viewModel.upcomingMoviesResponse.collectAsStateWithLifecycle().value

//    Log.d("upcomingMoviesScreen", "PopularMoviesScreen: $response")

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = Color.White
                ),
                title = {
                    Text(text = "Upcoming Movies")
                })
        }
    ) { paddingValue ->


        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues = paddingValue),
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

                                    ListOfMovies(result)
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


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
//@Preview(showBackground = true, device = "id:pixel_4")
fun ListOfMovies(result: ResultX) {

    val baseURl = Constants.BASE_URL_IMAGE + result.posterPath


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(baseURl)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = result.title,
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            modifier = Modifier.basicMarquee()

        )
    }


}







