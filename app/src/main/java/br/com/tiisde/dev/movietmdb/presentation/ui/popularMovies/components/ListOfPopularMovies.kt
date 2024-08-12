package br.com.tiisde.dev.movietmdb.presentation.ui.popularMovies.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.tiisde.dev.movietmdb.data.dto.Result
import br.com.tiisde.dev.movietmdb.presentation.ui.home.components.navigation.MoviesScreen
import br.com.tiisde.dev.movietmdb.presentation.ui.shimmer.ShimmerListItem
import br.com.tiisde.dev.movietmdb.util.Constants
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListOfPopularMovies(
    result: Result,
    navController: NavController
) {

    val baseURl = Constants.BASE_URL_IMAGE + result.posterPath


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {


            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(baseURl)
                    .crossfade(true)
                    .build(),
                loading = {
                    ShimmerListItem()
                },
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.clickable {
                    navController.navigate(
                     MoviesScreen.DetailMovie.name
                    )
                }
            )
//        SubcomposeAsyncImage(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data(baseURl)
//                .crossfade(true)
//                .build(),
//            loading = {
//                ShimmerListItem()
//            },
//            contentScale = ContentScale.Crop,
//            contentDescription = null
//        )
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