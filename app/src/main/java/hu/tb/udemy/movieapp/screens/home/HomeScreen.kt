package hu.tb.udemy.movieapp.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import hu.tb.udemy.movieapp.model.Movie
import hu.tb.udemy.movieapp.model.getMovies
import hu.tb.udemy.movieapp.navigation.MovieScreens
import hu.tb.udemy.movieapp.widget.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Movies")
            })
        }
    ) {
        MainContent(navController, it)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    paddingValues: PaddingValues,
    movieList: List<Movie> = getMovies()
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues),
    ) {
        items(items = movieList) {
            MovieRow(it) { movie ->
                navController.navigate(MovieScreens.DetailsScreen.name + "/$movie")
            }
        }
    }
}