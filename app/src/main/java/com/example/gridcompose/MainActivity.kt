package com.example.gridcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gridcompose.ui.theme.GridComposeTheme
import com.example.gridcompose.ui.theme.TopicsGridWithInset

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GridComposeTheme { // Usa tu tema de Material 3
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    TopicsGridWithInset()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GridComposeTheme {
        TopicsGridWithInset()
    }
}