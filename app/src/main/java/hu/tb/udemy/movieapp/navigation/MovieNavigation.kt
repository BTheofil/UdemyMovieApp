package hu.tb.udemy.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hu.tb.udemy.movieapp.screens.details.DetailsScreen
import hu.tb.udemy.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(MovieScreens.HomeScreen.name){
            HomeScreen(navController)
        }

        composable(MovieScreens.DetailsScreen.name){
            DetailsScreen(navController)
        }
    }
}