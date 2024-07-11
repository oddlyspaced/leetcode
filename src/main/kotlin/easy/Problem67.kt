package easy

import kotlin.math.pow

class Problem67 {
    fun addBinary(a: String, b: String): String {
        var a = a.reversed()
        var b = b.reversed()
        var index = 0
        var result = ""
        var carry = 0
        var digA = 0
        var digB = 0
        while (index < a.length || index < b.length) {
            if (index < a.length && index < b.length) {
                digA = a[index].digitToInt()
                digB = b[index].digitToInt()
            } else if (index < a.length) {
                digA = a[index].digitToInt()
                digB = 0
            } else if (index < b.length) {
                digA = 0
                digB = b[index].digitToInt()
            }
            index++
            var res = digA + digB + carry
            if (res == 2) {
                res = 0
                carry = 1
            } else if (res == 3) {
                res = 1
                carry = 1
            }
            else {
                carry = 0
            }
            result += res
        }
        if (carry == 1) {
            result = "${result}1"
        }

        return result.reversed()
    }
}

fun main() {
    println(Problem67().addBinary("1010", "1")) // 10101
}