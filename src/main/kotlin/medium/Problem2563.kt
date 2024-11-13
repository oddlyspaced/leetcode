package medium

class Problem2563 {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        fun search(left: Int, right: Int, target: Int): Int {
            var right = right
            var left = left
            while (left <= right) {
                val mid = (left + right) / 2
                if (nums[mid] >= target) {
                    right = mid + 1
                } else {
                    left = mid - 1
                }
            }
            return right
        }

        nums.sort()
        var res = 0L
        for (i in nums.indices) {
            val low = lower - nums[i]
            val up = upper - nums[i]
            res += search(i + 1, nums.size - 1, up + 1) - search(i + 1, nums.size - 1, low)
        }
        return res
    }

}