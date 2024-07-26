package medium

class Problem34 {
    private fun search(nums: IntArray, target: Int, leftBias: Boolean): Int {
        var l = 0
        var r = nums.size - 1
        var i = -1

        Int.MAX_VALUE
        while (l <= r) {
            val mid = (l + r) / 2
            if (target == nums[mid]) {
                i = mid
                if (leftBias) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            } else if (target < nums[mid]) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return i
    }

    fun searchRange(nums: IntArray, target: Int): IntArray {
        return intArrayOf(search(nums, target, true), search(nums, target, false))
    }
}

fun main() {
//    println(Problem34().searchRange(intArrayOf(5, 7, 7, 8, 8, 8), 5).joinToString(","))
    println(Problem34().searchRange(intArrayOf(1, 2, 3, 3, 3, 3, 4, 5, 9), 3).joinToString(","))
}