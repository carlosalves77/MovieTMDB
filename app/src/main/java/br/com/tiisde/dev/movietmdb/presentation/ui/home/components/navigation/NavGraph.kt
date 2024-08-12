package br.com.tiisde.dev.movietmdb.presentation.ui.home.components.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.tiisde.dev.movietmdb.data.dto.PopularMoviesDTO
import br.com.tiisde.dev.movietmdb.presentation.ui.detailMovie.DetailMovieScreen
import br.com.tiisde.dev.movietmdb.presentation.ui.popularMovies.PopularMoviesScreen
import br.com.tiisde.dev.movietmdb.presentation.ui.upcomingMovies.UpcomingMoviesScreen
import com.squareup.moshi.Moshi

@Composable
fun NavGraph(
    paddingValues: PaddingValues,
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = MoviesScreen.PopularMovies.name) {

        composable(
            route = MoviesScreen.PopularMovies.name
        ) {
            PopularMoviesScreen(paddingValues = paddingValues, navController = navController)
        }

        composable(
            route = MoviesScreen.UpcomingMovies.name
        ) {
            UpcomingMoviesScreen(paddingValues = paddingValues)
        }

        composable(
            route = MoviesScreen.DetailMovie.name
//            arguments = listOf(navArgument("movie") {
//                type = NavType.StringType
//                nullable = true
//            })
        ) { navBackStackEntry ->
            val title = navBackStackEntry.arguments?.getString("title")
            val poster = navBackStackEntry.arguments?.getString("poster")

            val movieDetail =  arrayListOf<String>()

            movieDetail.add(title.toString())
            movieDetail.add(poster.toString())

                DetailMovieScreen(movieDetail)

        }


    }
}


enum class MoviesScreen {
    PopularMovies,
    UpcomingMovies,
    DetailMovie
}