package easy

import kotlin.math.max

class Problem643 {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val sums = IntArray(nums.size)
        sums[0] = nums[0]
        for (i in 1..<k) {
            sums[i] += sums[i - 1] + nums[i]
        }
        for (i in k..<nums.size) {
            sums[i] += sums[i - 1] - nums[i - k] + nums[i]
        }
        var curAvg = (sums[k - 1]).toDouble() / k
        for (i in (k)..<nums.size) {
            curAvg = max(curAvg, sums[i].toDouble() / k)
        }
        return curAvg
    }
}

fun main() {
    println(Problem643().findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
    println(Problem643().findMaxAverage(intArrayOf(1, 2, 3, 4, 5, 6), 4))
}