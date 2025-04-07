package pe.edu.navigationjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.navigationjpc.ui.presentation.component.MyAppDrawer
import pe.edu.navigationjpc.ui.theme.DarkColorScheme
import pe.edu.navigationjpc.ui.theme.LightColorScheme
import pe.edu.navigationjpc.ui.theme.NavigationJpcTheme
import pe.edu.navigationjpc.ui.theme.ThemeType
import pe.edu.navigationjpc.ui.theme.sGreenDarkScheme
import pe.edu.navigationjpc.ui.theme.sGreenLightScheme
import pe.edu.navigationjpc.utils.conttexto
import pe.edu.navigationjpc.utils.isNight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeType = remember { mutableStateOf(ThemeType.GREEN) }
            val darkThereX= isNight()
            val darkTheme= remember { mutableStateOf(darkThereX) }
            conttexto.CONTEXTO_APPX=this

            val colorScheme=when(themeType.value){
                ThemeType.RED->{if(darkTheme.value) DarkColorScheme else LightColorScheme
                }
                ThemeType.GREEN->{ if(darkTheme.value) sGreenDarkScheme else sGreenLightScheme
                }
                else->{
                    LightColorScheme
                }
            }
            NavigationJpcTheme(colorScheme = colorScheme) {




                MyAppDrawer(darkMode = darkTheme, themeType = themeType)



                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android abd",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationJpcTheme(colorScheme = sGreenLightScheme) {
        Greeting("Android")
    }
}