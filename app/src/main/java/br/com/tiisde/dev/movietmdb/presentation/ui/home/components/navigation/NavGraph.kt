package br.com.tiisde.dev.movietmdb.presentation.ui.home.components.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            PopularMoviesScreen(paddingValues = paddingValues)
        }

        composable(
            route = MoviesScreen.UpcomingMovies.name
        ) {
            UpcomingMoviesScreen(paddingValues = paddingValues)
        }


    }
}


enum class MoviesScreen() {
    PopularMovies,
    UpcomingMovies
}