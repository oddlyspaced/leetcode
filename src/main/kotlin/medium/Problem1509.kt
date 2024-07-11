package medium

import kotlin.math.abs

class Problem1509 {
    fun minDifference(nums: IntArray): Int {
        if (nums.size <= 3) {
            return 0
        }
        nums.sort()

        var min = nums[nums.size - 1] - nums[0]

        repeat(4) {
            val l = it
            val r = nums.size - 4 + it
            min = kotlin.math.min(min, nums[r] - nums[l])
        }

        return min
    }
}

fun main() {
    println(Problem1509().minDifference(intArrayOf(5, 3, 2, 4)))

    println(Problem1509().minDifference(intArrayOf(1, 5, 0, 10, 14)))

    println(Problem1509().minDifference(intArrayOf(6, 6, 0, 1, 1, 4, 6)))
}