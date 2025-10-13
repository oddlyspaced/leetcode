package old.medium

import kotlin.math.ceil

class Problem2064 {
    fun minimizedMaximum(n: Int, quantities: IntArray): Int {
        fun checkDist(x: Int): Boolean {
            val s = quantities.sumOf {
                ceil(it / x.toDouble())
            }
            return s.toInt() <= n
        }

        var l = 1
        var r = quantities.max()
        var res = 0
        while (l <= r) {
            val mid = (l + r) / 2
            if (checkDist(mid)) {
                res = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return res
    }
}

fun main() {
    println(Problem2064().minimizedMaximum(6, intArrayOf(11, 6)))
}