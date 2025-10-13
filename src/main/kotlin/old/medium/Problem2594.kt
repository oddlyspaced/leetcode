package old.medium

import kotlin.math.sqrt

// https://www.youtube.com/watch?v=RHct_Pz9EBo&ab_channel=NeetCodeIO
// https://leetcode.com/problems/minimum-time-to-repair-cars/solutions/6541384/binary-search-visualization-math-python-c-java
class Problem2594 {
    private fun timeIsSuff(ranks: IntArray, cars: Int, minGiven: Long): Boolean {
        var carsDone = 0L
        for (r in ranks) {
            val c2 = minGiven / r
            val c = kotlin.math.sqrt(c2.toDouble()).toLong()
            carsDone += c
        }
        return carsDone >= cars
    }

    fun repairCars(ranks: IntArray, cars: Int): Long {
        var l = 1L
        var r = 1e14.toLong()
        while (l < r) {
            val mid = (l + r) / 2
            if (timeIsSuff(ranks, cars, mid)) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return l
    }
}

fun main() {
    println(Problem2594().repairCars(intArrayOf(4, 2, 3, 1), 10))
    println(Problem2594().repairCars(intArrayOf(5, 1, 8), 6))
}