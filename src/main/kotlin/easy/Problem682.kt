package easy

class Problem682 {
    fun calPoints(operations: Array<String>): Int {
        val data = IntArray(operations.size)
        var last = -1
        operations.forEach { op ->
            when (op) {
                "+" -> {
                    val sum = data[last] + data[last - 1]
                    data[++last] = sum
                }

                "D" -> {
                    val d = data[last] * 2
                    data[++last] = d
                }

                "C" -> {
                    last--
                }

                else -> {
                    data[++last] = op.toInt()
                }
            }
        }
        var sum = 0
        for (i in 0..last) {
            sum += data[i]
        }
        return sum
    }
}

fun main() {
    println(Problem682().calPoints(arrayOf("5", "2", "C", "D", "+")))
    println(Problem682().calPoints(arrayOf("5", "-2", "4", "C", "D", "9", "+", "+")))
    println(Problem682().calPoints(arrayOf("1", "C")))
}