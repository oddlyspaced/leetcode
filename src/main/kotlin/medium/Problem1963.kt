package medium

import kotlin.math.floor
import kotlin.math.max

class Problem1963 {
    fun minSwaps(s: String): Int {
        var counter = 0
        var res = 0
        for (c in s) {
            when (c) {
                ']' -> {
                    counter++
                    res = max(counter, res)
                }

                '[' -> {
                    counter--
                }
            }
        }
        return (res + 1) / 2
    }
}

fun main() {
    println(Problem1963().minSwaps("][]["))
    println(Problem1963().minSwaps("]]][[["))
    println(Problem1963().minSwaps("[]"))
    println(Problem1963().minSwaps("[]]["))
    println(Problem1963().minSwaps("]]][[["))
}