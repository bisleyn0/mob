package pe.edu.navigationjpc.ui.presentation.screens

import pe.edu.navigationjpc.utils.evaluateExpression

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorScreen() {
    var input by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    fun append(value: String) {
        input += value
    }

    fun clear() {
        input = ""
        result = ""
    }

    fun calculate() {
        try {
            result = evaluateExpression(input)
        } catch (e: Exception) {
            result = "Error"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = input, fontSize = 24.sp, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Resultado: $result", fontSize = 20.sp, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))

        val buttons = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("0", ".", "%", "+"),
            listOf("^", "√", "C", "=")
        )

        buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { symbol ->
                    Button(
                        onClick = {
                            when (symbol) {
                                "C" -> clear()
                                "=" -> calculate()
                                else -> append(symbol)
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        Text(symbol, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}