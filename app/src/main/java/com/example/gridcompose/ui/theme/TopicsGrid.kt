package com.example.gridcompose.ui.theme // O donde prefieras

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridcompose.data.DataSource

@Composable
fun TopicsGridWithInset(modifier: Modifier = Modifier) { // Renombrado para claridad
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        // Combina el padding de los insets con tu padding personalizado
        contentPadding = PaddingValues(
            top = WindowInsets.statusBars.asPaddingValues()
                .calculateTopPadding() + 8.dp, // Espacio para la barra de estado + tu padding
            bottom = 8.dp, // Tu padding inferior
            start = 8.dp,  // Tu padding lateral
            end = 8.dp     // Tu padding lateral
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(DataSource.topics) { topic ->
            TopicCard(topic = topic)
        }
    }
}

// Alternativamente, puedes aplicar el padding de la barra de estado al contenedor completo:
@Composable
fun TopicsGridScreenWithInsetPadding() {
    TopicsGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.statusBars.asPaddingValues()) // Aplica el padding de la barra de estado aquí
    )
}


@Preview(showBackground = true)
@Composable
fun TopicsGridWithInsetPreview() {
    // GridComposeTheme {
    TopicsGridWithInset()
    // }
}

@Preview(showBackground = true)
@Composable
fun TopicsGridScreenWithInsetPaddingPreview() {
    // GridComposeTheme {
    TopicsGridScreenWithInsetPadding()
    // }
}


@Composable
fun TopicsGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // DEFINE DOS COLUMNAS
        contentPadding = PaddingValues(8.dp), // Padding alrededor de todo el grid
        verticalArrangement = Arrangement.spacedBy(8.dp), // Espacio vertical entre items
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Espacio horizontal entre items
        modifier = modifier.fillMaxSize()
    ) {
        items(DataSource.topics) { topic ->
            TopicCard(topic = topic)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicsGridPreview() {
    // Asegúrate de tener un tema si TopicCard usa MaterialTheme
    // GridComposeTheme { // Suponiendo que tu tema se llama así
    TopicsGrid()
    // }
}
