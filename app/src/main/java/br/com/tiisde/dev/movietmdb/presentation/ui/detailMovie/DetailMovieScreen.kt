package br.com.tiisde.dev.movietmdb.presentation.ui.detailMovie

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import br.com.tiisde.dev.movietmdb.presentation.ui.shimmer.ShimmerListItem
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun DetailMovieScreen(
//    popularMovies: Result?
    title: String?,
    imagePoster: String?
) {

    Log.d("DetailMovieScreen", "DetailMovieScreen: $title")
    Log.d("DetailMovieScreen", "DetailMovieScreen: $imagePoster")

    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imagePoster)
                .crossfade(true)
                .build(),
            loading = {
                ShimmerListItem()
            },
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
        )

    }




}