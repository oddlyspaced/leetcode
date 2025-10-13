package old.medium

import kotlin.math.sqrt

class Problem650 {

    private fun prime(n: Int): Int {
        var ops = 0
        var n = n
        var i = 2
        while (n % i == 0) {
            ops += i
            n /= i
        }
        i++
        while (n > 1) {
            while (n % i == 0) {
                ops += i
                n /= i
            }
            i += 2
        }
        return ops
    }

    fun minSteps(n: Int): Int {
        return prime(n)
    }
}

fun main() {
    println(Problem650().minSteps(3))
    println(Problem650().minSteps(1))
    println(Problem650().minSteps(2))
    println(Problem650().minSteps(4))
    println(Problem650().minSteps(21))
}