package grind75

/**
 * Created by Hardik Srivastava on 15/10/25
 */
class Problem704 {
    fun search(nums: IntArray, target: Int): Int {
        if (target > nums.last() || target < nums.first()) {
            return -1
        }
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val m = l + ((r - l) / 2)
            if (nums[m] == target) {
                return m
            } else if (nums[m] < target) {
                l = m + 1
            } else {
                r = m - 1
            }
        }
        return -1
    }
}