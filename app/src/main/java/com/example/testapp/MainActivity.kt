package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}



@Composable
fun CustomTopAppBar() {
    val primary = MaterialTheme.colorScheme.primary

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(92.dp) // Задайте желаемую высоту
    ) {
        Text(
            text = "Мои Дела",
            fontSize = 32.sp,
            fontWeight = FontWeight(500),
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(
                    start = 60.dp,
                    top = 50.dp,
                    end = 154.dp,
                    bottom = 4.dp
                ),
            color = Color.Black
        )
    }
}

@Composable
fun MainScreen(numOfChecked: String) {
    val primary = MaterialTheme.colorScheme.primary

    Scaffold(
        containerColor = primary,
        topBar = {
            CustomTopAppBar()
        },
        content = { paddingValues ->
            Column (
                modifier = Modifier.fillMaxSize(),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Выполнено $numOfChecked заданий",
                        color = Color(0x6000004D),
                        modifier = Modifier.padding(paddingValues).padding(bottom = 16.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                        .fillMaxSize()
                        .background(primary)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    for (i in 0..100) {
                        Text(
                            text = "Item $i",
                            color = Color.Black,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(vertical = 10.dp),
                            textAlign = TextAlign.Center

                        )
                    }
                }
            }
        }
    )
}

@Composable
fun MyApp() {
    val lightColors = lightColorScheme(
        primary = Color(0xFFF7F6F2)
        // add more colors
    )
    val darkColors = darkColorScheme(
        primary = Color(0xFF161618)
        // add more colors
    )

    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColors else lightColors
    ) {
        MainScreen("5")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestAppTheme {
        MyApp()
    }
}