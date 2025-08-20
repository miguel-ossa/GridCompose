package com.example.gridcompose.ui.theme // O donde prefieras poner tus Composables de UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gridcompose.model.Topic
import com.example.gridcompose.R

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = topic.imageRes),
                contentDescription = stringResource(id = topic.name), // Descripción para accesibilidad
                modifier = Modifier
                    .size(68.dp) // Tamaño fijo para la imagen
                    .aspectRatio(1f), // Mantiene la imagen cuadrada
                contentScale = ContentScale.Crop // O la escala que prefieras
            )

            Column(
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
                    .fillMaxWidth() // Para que la columna de texto ocupe el espacio restante
            ) {
                Text(
                    text = stringResource(id = topic.name),
                    style = MaterialTheme.typography.bodyMedium,
                    //modifier = Modifier.padding(bottom = 8.dp)
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.ic_grain), contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = topic.availableCourses.toString(), // Muestra el número de cursos
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}
