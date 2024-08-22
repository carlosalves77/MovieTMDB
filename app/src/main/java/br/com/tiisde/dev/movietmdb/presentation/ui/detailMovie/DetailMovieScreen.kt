package br.com.tiisde.dev.movietmdb.presentation.ui.detailMovie

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.tiisde.dev.movietmdb.presentation.ui.shimmer.ShimmerListItem
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest

@Composable
fun DetailMovieScreen(
    movieTitle: String?,
    imagePoster: String?,
    movieDescription: String?
) {

    Log.d("DetailMovieScreen", "DetailMovieScreen: $movieTitle")
    Log.d("DetailMovieScreen", "DetailMovieScreen: $imagePoster")


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
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

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = movieTitle!!,
            fontSize = 20.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = movieDescription!!,
            fontSize = 20.sp,
            color = Color.White
        )


    }




}