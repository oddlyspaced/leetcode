package medium

class Problem241 {

    private fun operate(operation: Char, x: Int, y: Int): Int {
        return when (operation) {
            '+' -> x + y
            '-' -> x - y
            '*' -> x * y
            else -> {
                0
            }
        }
    }

    fun diffWaysToCompute(expression: String): List<Int> {
        val operations = setOf('+', '-', '*')
        fun backtrack(left: Int, right: Int): List<Int> {
            val res = arrayListOf<Int>()
            for (i in left..right) {
                val op = expression[i]
                if (operations.contains(op)) {
                    val num1 = backtrack(left, i - 1)
                    val num2 = backtrack(i + 1, right)
                    num1.forEach { n1 ->
                        num2.forEach { n2 ->
                            res.add(operate(op, n1, n2))
                        }
                    }
                }
            }
            if (res.isEmpty()) {
                val t = expression.substring(left, right + 1)
                if (t.isNotEmpty()) {
                    res.add(t.toInt())
                }
            }
            return res
        }
        return backtrack(0, expression.length - 1)
    }
}

fun main() {
    println(Problem241().diffWaysToCompute("2-1-1").joinToString(","))
}