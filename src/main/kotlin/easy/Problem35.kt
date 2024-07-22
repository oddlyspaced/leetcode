package easy

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            val mid = (l + r) / 2
            if (target < nums[mid]) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return l
    }
}

fun main() {
    println(Solution().searchInsert(intArrayOf(3, 4, 5, 6), 2))
    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 5))
}