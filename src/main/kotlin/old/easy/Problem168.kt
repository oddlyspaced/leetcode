package old.easy

class Problem168 {
    fun convertToTitle(columnNumber: Int): String {
        var cn = columnNumber
        var res = ""
        while (cn > 0) {
            val rem = cn % 26
            println(rem)
            cn /= 26
            //
        }
        return ""
    }
}

fun main() {
    println(Problem168().convertToTitle(28))
}