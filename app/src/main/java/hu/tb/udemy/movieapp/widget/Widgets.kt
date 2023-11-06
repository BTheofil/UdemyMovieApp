package hu.tb.udemy.movieapp.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import hu.tb.udemy.movieapp.model.Movie
import hu.tb.udemy.movieapp.model.getMovies

@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }

    ElevatedCard(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(movie.id)
            },
        shape = (RoundedCornerShape(CornerSize(16.dp)))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                tonalElevation = 4.dp
            ) {
                Image(
                    painter = rememberAsyncImagePainter(movie.images.first()),
                    contentDescription = "Movie Poster"
                )
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Director: " + movie.director,
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = "Released: " + movie.year,
                    style = MaterialTheme.typography.labelMedium
                )

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp
                                    )
                                ) {
                                    append("Plot: ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Light
                                    )
                                ) {
                                    append(movie.plot)
                                }
                            },
                            modifier = Modifier.padding(16.dp),
                        )
                        Divider(modifier = Modifier.padding(4.dp))
                        Text(
                            text = "Director: " + movie.director,
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            text = "Actors: " + movie.actors,
                            style = MaterialTheme.typography.labelMedium
                        )
                        Text(
                            text = "Rating: " + movie.rating,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }


                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            expanded = !expanded
                        },
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down arrow",
                    tint = Color.DarkGray
                )
            }
        }
    }
}

@Preview
@Composable
fun MovieRowPreview() {
    MovieRow(movie = getMovies()[0], onItemClick = {})
}