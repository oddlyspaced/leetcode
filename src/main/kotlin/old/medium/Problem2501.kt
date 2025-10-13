package old.medium

import kotlin.math.max

class Problem2501 {
    fun longestSquareStreak(nums: IntArray): Int {
        var res = -1
        val data = hashMapOf<Long, Int>()
        nums.forEach {
            data[it.toLong()] = (data[it.toLong()] ?: 0) + 1
        }

        for (i in nums.indices) {
            var size = 1
            var cur = nums[i]
            while (true) {
                if (data[(cur.toLong() * cur)] != null) {
                    size++
                    cur *= cur
                } else {
                    break
                }
            }
            if (size > 1) {
                res = max(res, size)
            }
        }
        return res
    }
}

fun main() {
    println(Problem2501().longestSquareStreak(intArrayOf(4, 3, 6, 16, 8, 2)))
    println(Problem2501().longestSquareStreak(intArrayOf(2, 3, 5, 6, 7)))
}