package old.medium

// https://www.youtube.com/watch?v=OHZqAc6h3Us&ab_channel=NeetCodeIO
// no clue personally couldn't understand :(
class Problem2560 {
    fun minCapability(nums: IntArray, k: Int): Int {
        fun isValid(capability: Int): Boolean {
            var i = 0
            var count = 0
            while (i < nums.size) {
                if (nums[i] <= capability) {
                    i += 2
                    count++
                } else {
                    i++
                }
                if (count == k) {
                    break
                }
            }
            return count == k
        }

        var left = nums.min()
        var right = nums.max()
        var res = 0
        while (left <= right) {
            val mid = (left + right) / 2
            if (isValid(mid)) {
                res = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return res
    }
}