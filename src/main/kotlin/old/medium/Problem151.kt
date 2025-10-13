package old.medium

class Problem151 {
    fun reverseWords(s: String): String {
        val res = StringBuilder()
        s.trim().split(" ").reversed().forEach {
            if (it.isNotBlank()) {
                res.append("$it ")
            }
        }
        return res.toString().trim()
    }
}

fun main() {
    println(Problem151().reverseWords("a good   example"))
}