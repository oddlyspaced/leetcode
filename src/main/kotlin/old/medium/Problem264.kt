package old.medium

import kotlin.math.min

class Problem264 {
    fun nthUglyNumber(n: Int): Int {
        val res = arrayListOf(1)
        var c2 = 0
        var c3 = 0
        var c5 = 0

        for (i in 0..<n) {
            val t2 = res[c2] * 2
            val t3 = res[c3] * 3
            val t5 = res[c5] * 5
            val smallest = min(t2, min(t3, t5))
            res.add(smallest)
            if (smallest == t2) {
                c2++
            }
            if (smallest == t3) {
                c3++
            }
            if (smallest == t5) {
                c5++
            }
        }

        return res[n - 1]
    }
}

fun main() {
    println(Problem264().nthUglyNumber(12))
}
// 1,
// 2 * 1,
// 3 * 1,
// 2 * 2,
// 5 * 1,
// 3 * 2,
// 2 * 2 * 2,
// 3 * 3,
// 5 * 2,
// 2 * 2 * 3,