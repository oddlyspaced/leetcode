package easy

class Problem415 {
    fun addStrings(num1: String, num2: String): String {
        var carry = 0
        var res = ""
        val n1 = num1.reversed().toCharArray().map { it.digitToInt() }
        val n2 = num2.reversed().toCharArray().map { it.digitToInt() }

        val minLimit = minOf(n1.size, n2.size)
        val maxLimit = maxOf(n1.size, n2.size)
        for (i in 0..<minLimit) {
            var temp = n1[i] + n2[i] + carry
//            println("${n1[i]} + ${n2[i]} + $carry = $temp")
            if (temp > 9) {
                temp -= 10
                carry = 1
            } else {
                carry = 0
            }
            res += temp
        }
        val temp = if (n1.size > n2.size) n1 else n2
        for (i in minLimit..<maxLimit) {
            var t = temp[i] + carry
            if (t > 9) {
                t -= 10
                carry = 1
            } else {
                carry = 0
            }
            res += t
        }
        if (carry == 1) {
            res += '1'
        }
        return res.reversed()
    }
}

fun main() {
    println(Problem415().addStrings("11", "123"))
    println(Problem415().addStrings("456", "77"))
    println(Problem415().addStrings("0", "0"))
    println(Problem415().addStrings("9", "1"))
    println(Problem415().addStrings("9", "99"))
}