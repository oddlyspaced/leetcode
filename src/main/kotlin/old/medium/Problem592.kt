package old.medium

import kotlin.math.floor

class Problem592 {
    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    // a / b + c / d
    private fun addFracs(a: Int, b: Int, c: Int, d: Int): Pair<Int, Int> {
        val num = (a * d) + (c * b)
        val den = b * d
        val res = gcd(num, den)
        return Pair(num / res, den / res)
    }

    fun fractionAddition(expression: String): String {
        var num = 0
        var den = 1
        val sb = StringBuilder(expression)
        while (sb.contains("/")) {
            val slash = sb.indexOf("/")
            var tempNum = ""
            var tempDen = ""

            var i = 1
            while ((slash - i) >= 0) {
                val c = sb[slash - i]
                if (c == '+' || c == '-') {
                    tempNum = c + tempNum
                    break
                } else {
                    tempNum = c + tempNum
                }
                i++
            }
            i = 1
            while ((slash + i) < sb.length) {
                val c = sb[slash + i]
                if (c == '+' || c == '-') {
                    break
                } else {
                    tempDen += c
                }
                i++
            }
            sb[slash] = ';'
            val t = addFracs(num, den, tempNum.toInt(), tempDen.toInt())
            num = t.first
            den = t.second
        }
        if (den < 0) {
            num *= -1
            den *= -1
        }
        return "$num/$den"
    }
}

fun main() {
    println(Problem592().fractionAddition("-1/2+1/2"))
    println(Problem592().fractionAddition("-1/2+1/2+1/3"))
    println(Problem592().fractionAddition("1/3-1/2"))
}