package br.com.tiisde.dev.movietmdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import br.com.tiisde.dev.movietmdb.presentation.ui.home.HomeScreen
import br.com.tiisde.dev.movietmdb.presentation.ui.navigation.NavGraph
import br.com.tiisde.dev.movietmdb.presentation.ui.popularMovies.PopularMoviesScreen
import br.com.tiisde.dev.movietmdb.presentation.ui.upcomingMovies.UpcomingMoviesScreen
import br.com.tiisde.dev.movietmdb.ui.theme.MovieTMDBTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val splashScreen = installSplashScreen()

        setContent {
            MovieTMDBTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    splashScreen.setKeepOnScreenCondition { true }
                    HomeScreen()
                }

            }
        }
    }
}

