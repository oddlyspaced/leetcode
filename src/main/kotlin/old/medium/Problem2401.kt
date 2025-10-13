package old.medium

import kotlin.math.max

class Problem2401 {
    fun longestNiceSubarray(nums: IntArray): Int {
        var maxLength = 1
        var left = 0
        var used = 0
        for (right in nums.indices) {
            while ((used and nums[right]) != 0) {
                used = used xor nums[left]
                left++
            }

            used = used or nums[right]
            maxLength = max(maxLength.toDouble(), (right - left + 1).toDouble()).toInt()
        }
        return maxLength
    }
}