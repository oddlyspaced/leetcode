package easy

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (target > nums[nums.size - 1]) {
            return nums.size
        } else if (target < nums[0]) {
            return 0
        }

        var output = nums.size
        for (i in nums.indices) {
            if (nums[i] >= target) {
                output = i
                break
            }
        }

        return output
    }
}

fun main() {
    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 2))
}