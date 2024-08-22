package br.com.tiisde.dev.movietmdb.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.tiisde.dev.movietmdb.presentation.ui.detailMovie.DetailMovieScreen

@Composable
fun SecondNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DetailScreen.DetailMovieScreen.name) {

        composable(
            route = "${DetailScreen.DetailMovieScreen.name}/{result}/{imagePoster}",
        ) { backStackEntry ->

            val resultTitle = backStackEntry.arguments?.getString("result")
            val imagePoster = backStackEntry.arguments?.getString("imagePoster")

        }

    }
}


enum class DetailScreen {
    DetailMovieScreen
}