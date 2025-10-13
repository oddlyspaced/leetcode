package old.medium

import kotlin.math.pow

class Problem1780 {
    private fun findLargestPower(n: Int): Int {
        var p = 0
        while (3.0.pow(p) <= n.toDouble()) {
            p++
        }
        return p - 1
    }

    fun checkPowersOfThree(n: Int): Boolean {
        val powers = hashSetOf<Int>()
        var num = n
        while (num > 0) {
            val t = findLargestPower(num)
            if (powers.contains(t)) {
                return false
            }
            num -= (3.0.pow(t)).toInt()
            powers.add(t)
        }
        return true
    }
}

fun main() {
    println(Problem1780().checkPowersOfThree(12))
    println(Problem1780().checkPowersOfThree(91))
    println(Problem1780().checkPowersOfThree(21))
}