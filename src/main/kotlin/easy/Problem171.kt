package easy

class Problem171 {
    fun titleToNumber(columnTitle: String): Int {
        var res = 0
        columnTitle.forEach { it ->
            res = res * 26 + (it - 'A' + 1)
        }
        return res
    }
}

fun main() {
    println(Problem171().titleToNumber("A"))
    println(Problem171().titleToNumber("AB"))
    println(Problem171().titleToNumber("ZY"))
}