package medium

import kotlin.math.abs

class Problem29 {
    fun divide(dividend: Int, divisor: Int): Int {
        val isDividendNeg = if (dividend < 0) true else false
        val isDivisorNeg = if (divisor < 0) true else false

        var dividend = abs(dividend)
        var divisor = abs(divisor)


        var count = 0
        while (dividend > 0) {
            dividend -= divisor
            count++
        }
        if (dividend < 0) {
            count--
        }
        if (isDividendNeg && isDivisorNeg) {
            return count
        } else if (isDividendNeg || isDivisorNeg) {
            return -count
        }
        return count
    }
}

fun main() {
    println(Problem29().divide(1, 1))
}