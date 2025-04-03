package medium

/**
 * Created by Hardik Srivastava on 04/04/25
 */
class Problem2874 {
    fun maximumTripletValue(nums: IntArray): Long {
        val minPrefix = IntArray(nums.size)
        minPrefix[0] = nums[0];
        for (i in 1..<nums.size) {
            minPrefix[i] = maxOf(minPrefix[i - 1], nums[i - 1])
        }
        val maxSuffix = IntArray(nums.size)
        maxSuffix[nums.size - 1] = nums[nums.size - 1]
        for (i in (nums.size - 2) downTo 0) {
            maxSuffix[i] = maxOf(maxSuffix[i + 1], nums[i + 1])
        }
        var res = 0L
        for (j in 1..<nums.size - 1) {
            if (minPrefix[j] > nums[j]) {
                res = maxOf(res, (minPrefix[j] - nums[j]) * maxSuffix[j].toLong());
            }
        }
        return res
    }
}