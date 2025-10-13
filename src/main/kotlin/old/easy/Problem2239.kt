package old.easy

import kotlin.math.abs

class Problem2239 {
    fun findClosestNumber(nums: IntArray): Int {
        var dist = abs(nums[0])
        var num = nums[0]

        for (n in nums) {
            if (abs(n) <= dist) {
                if (abs(n) < num || n > num) {
                    dist = abs(n)
                    num = n
                }
            }
        }
        return num

    }
}

fun main() {
    println(Problem2239().findClosestNumber(intArrayOf(2, -1, 1)))
}