package br.com.tiisde.dev.movietmdb.presentation.ui.home.components.navigation

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
            route = "${MoviesScreen.DetailMovie.name}/{result}/{imagePoster}",

        ) { backStackEntry ->

            val resultTitle = backStackEntry.arguments?.getString("result")
            val imagePoster = backStackEntry.arguments?.getString("imagePoster")


            DetailMovieScreen(
                resultTitle,
                imagePoster
            )


        }


    }
}


enum class MoviesScreen {
    PopularMovies,
    UpcomingMovies,
    DetailMovie
}