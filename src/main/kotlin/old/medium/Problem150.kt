package old.medium

class Problem150 {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<String>()
        var i = 0
        while (i < tokens.size) {
            when (val t = tokens[i]) {
                "+" -> {
                    val v1 = stack.removeLast().toInt()
                    val v2 = stack.removeLast().toInt()
                    stack.add((v1 + v2).toString())
                }

                "-" -> {
                    val v1 = stack.removeLast().toInt()
                    val v2 = stack.removeLast().toInt()
                    stack.add((v2 - v1).toString())
                }

                "*" -> {
                    val v1 = stack.removeLast().toInt()
                    val v2 = stack.removeLast().toInt()
                    stack.add((v1 * v2).toString())
                }

                "/" -> {
                    val v1 = stack.removeLast().toInt()
                    val v2 = stack.removeLast().toInt()
                    stack.add((v2 / v1).toString())
                }

                else -> {
                    stack.add(t)
                }
            }
            i++
        }
        return stack.last().toInt()
    }
}

fun main() {
    println(Problem150().evalRPN(arrayOf("2", "1", "+", "3", "*")))
    println(Problem150().evalRPN(arrayOf("4", "13", "5", "/", "+")))
}