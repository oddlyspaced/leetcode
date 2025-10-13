package old.medium

import kotlin.math.sqrt

class Problem2523 {
    private fun isPrime(n: Int): Boolean {
        if (n <= 1) {
            return false
        }
        if (n <= 3) {
            return true
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false
        }
        val lim = sqrt(n.toDouble()).toInt()
        for (i in 5..lim) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

    fun closestPrimes(left: Int, right: Int): IntArray {
        val primes = mutableListOf<Int>()
        for (i in left..right) {
            if (isPrime(i)) {
                primes.add(i)
            }
        }
        var res = intArrayOf(-1, -1)
        var diff = Int.MAX_VALUE
        for (i in 0..<primes.size - 1) {
            val t = primes[i + 1] - primes[i]
            if (t < diff) {
                diff = t
                res = intArrayOf(primes[i], primes[i + 1])
            } else if (t == diff) {
                if (primes[i] < res[0]) {
                    res = intArrayOf(primes[i], primes[i + 1])
                }
            }
        }
        return res
    }
}

fun main() {
    println(Problem2523().closestPrimes(10, 19).joinToString(","))
    println(Problem2523().closestPrimes(4, 6).joinToString(","))
    println(Problem2523().closestPrimes(19, 31).joinToString(","))
}