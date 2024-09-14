package medium

import kotlin.math.abs

class Problem50 {
    fun myPow(x: Double, n: Int): Double {
        if (x == 1.0) {
            return 1.0
        }
        if (x == -1.0) {
            return if (n % 2 == 0) {
                1.0
            } else {
                -1.0
            }
        }
        if (n < -Int.MAX_VALUE) {
            return 0.0
        }
        if (n == 0) {
            return 1.0
        }
        var res = 1.0
        repeat(abs(n)) {
            res *= x
        }
        if (n < 0) {
            res = 1 / res
        }
        return res
    }
}

fun main() {
    println(-Int.MAX_VALUE)
    println(Problem50().myPow(2.0, 10))
    println(Problem50().myPow(2.0, -2))
}