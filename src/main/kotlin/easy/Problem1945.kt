package easy

class Problem1945 {
    private fun digSum(num: String): String {
        var sum = 0L
        num.forEach {
            sum += it.digitToInt()
        }
        return sum.toString()
    }

    fun getLucky(s: String, k: Int): Int {
        val sb = StringBuilder()
        s.forEach {
            sb.append(it - 'a' + 1)
        }
        var sum = sb.toString()
        repeat(k) {
            sum = digSum(sum)
        }
        return sum.toInt()
    }
}

fun main() {
    println(Problem1945().getLucky("iiii", 1))
    println(Problem1945().getLucky("leetcode", 2))
    println(Problem1945().getLucky("fleyctuuajsr", 5))
}