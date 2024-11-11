package medium

import kotlin.math.sqrt

class Problem2601 {
    fun isPrime(n: Int): Boolean {
        for (i in 2..(sqrt(n.toDouble()).toInt())) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

    fun primeSubOperation(nums: IntArray): Boolean {
        var prev = 0
        nums.forEach { n ->
            val lim = n - prev - 1
            var primeMax = 0
            for (p in lim downTo 2) {
                if (isPrime(p)) {
                    primeMax = p
                    break
                }
            }

            if ((n - primeMax) <= prev) {
                return false
            }
            prev = n - primeMax
        }
        return true
    }
}

fun main() {
    println(Problem2601().primeSubOperation(intArrayOf(4, 9, 6, 10)))
    println(Problem2601().primeSubOperation(intArrayOf(3, 4, 10, 15, 6)))
}