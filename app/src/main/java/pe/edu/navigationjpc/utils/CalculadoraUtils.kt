package pe.edu.navigationjpc.utils

import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.function.Function
import kotlin.math.pow
import kotlin.math.sqrt

fun evaluateExpression(expression: String): String {
    return try {
        var expr = expression
            .replace("√", "sqrt")
            .replace("^", "**")

        // Manejar potencia "**" manualmente
        val regex = Regex("""(\d+(?:\.\d+)?)\*\*(\d+(?:\.\d+)?)""")
        while (regex.containsMatchIn(expr)) {
            expr = regex.replace(expr) {
                val base = it.groupValues[1].toDouble()
                val exp = it.groupValues[2].toDouble()
                base.pow(exp).toString()
            }
        }

        // Crear función sqrt para exp4j
        val sqrtFunction = object : Function("sqrt", 1) {
            override fun apply(vararg args: Double): Double {
                return sqrt(args[0])
            }
        }

        val result = ExpressionBuilder(expr)
            .function(sqrtFunction)
            .build()
            .evaluate()

        result.toString()
    } catch (e: Exception) {
        "Error"
    }
}
