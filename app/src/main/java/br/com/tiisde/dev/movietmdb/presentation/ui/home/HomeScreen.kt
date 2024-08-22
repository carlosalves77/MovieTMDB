package br.com.tiisde.dev.movietmdb.presentation.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import br.com.tiisde.dev.movietmdb.presentation.ui.navigation.MoviesScreen
import br.com.tiisde.dev.movietmdb.presentation.ui.navigation.NavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        TextButton(onClick = {
                         navController.navigate(MoviesScreen.PopularMovies.name)
                        }) {
                            Text(
                                text = "Popular Movies",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,

                                )
                        }

                        TextButton(onClick = {
                            navController.navigate(MoviesScreen.UpcomingMovies.name)
                        }) {
                            Text(
                                text = "Upcoming Movies",
                                fontSize = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }


                    }
                })
        }
    ) { paddingValues ->
        NavGraph(paddingValues, navController)
    }

}