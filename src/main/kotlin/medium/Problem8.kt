package medium

class Problem8 {
    fun myAtoi(s: String): Int {
        var res = 0L
        var isNeg = 1
        var s = s.trim()
        if (s.isEmpty()) {
            return 0
        }
        if (s[0] == '-') {
            isNeg = -1
            s = s.substring(1)
        } else if (s[0] == '+') {
            s = s.substring(1)
        }


        for (c in s) {
            if (c.isDigit()) {
                res = (res * 10) + c.digitToInt()
            } else {
                break
            }
            if (res > Int.MAX_VALUE) {
                break
            }
        }
        if (res > 2147483647) {
            if (isNeg == -1) {
                return (Int.MAX_VALUE * -1) - 1
            }
            return Int.MAX_VALUE
        } else {
            return (res * isNeg).toInt()
        }
    }
}

fun main() {
    println(Problem8().myAtoi("9223372036854775808"))
}