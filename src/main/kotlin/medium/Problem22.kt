package medium

class Problem22 {

    private val res = arrayListOf<String>()
    private var sb = StringBuilder()

    private fun gen(open: Int, closed: Int, n: Int) {
        if (open == n && closed == n) {
            res.add(sb.toString())
            return
        }
        if (open < n) {
            sb.append("(")
            gen(open + 1, closed, n)
            sb.deleteAt(sb.length - 1)
        }
        if (closed < open) {
            sb.append(")")
            gen(open, closed + 1, n)
            sb.deleteAt(sb.length - 1)
        }
    }

    fun generateParenthesis(n: Int): List<String> {
        gen(0, 0, n)
        return res
    }
}

fun main() {
    println(Problem22().generateParenthesis(2))
}