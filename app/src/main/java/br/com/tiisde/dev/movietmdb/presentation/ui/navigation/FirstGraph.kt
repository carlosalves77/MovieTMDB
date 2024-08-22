package br.com.tiisde.dev.movietmdb.presentation.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.tiisde.dev.movietmdb.presentation.ui.detailMovie.DetailMovieScreen
import br.com.tiisde.dev.movietmdb.presentation.ui.popularMovies.PopularMoviesScreen
import br.com.tiisde.dev.movietmdb.presentation.ui.upcomingMovies.UpcomingMoviesScreen

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
            route = "${MoviesScreen.DetailMovie.name}/{movieTitle}/{imagePoster}/{movieDescription}",
            ) { backStackEntry ->

            val resultTitle = backStackEntry.arguments?.getString("movieTitle")
            val imagePoster = backStackEntry.arguments?.getString("imagePoster")
            val movieDescription = backStackEntry.arguments?.getString("movieDescription")

            DetailMovieScreen(
                resultTitle,
                imagePoster,
                movieDescription
            )

        }


    }
}


enum class MoviesScreen {
    PopularMovies,
    UpcomingMovies,
    DetailMovie
}