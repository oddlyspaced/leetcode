package medium

class Problem2419 {
    fun longestSubarray(nums: IntArray): Int {
        val maxVal = nums.max()

        var curLen = if (nums[0] == maxVal) {
            // starts with the max value sequence
            1
        } else 0
        var maxLen = curLen

        for (i in 1..<nums.size) {
            if (nums[i] == nums[i - 1] && nums[i] == maxVal) {
                curLen++
            } else if (nums[i] == maxVal) { // start of new sequence
                curLen = 1
//                println("CUR : " + curLen)
//                if (maxLen < curLen) {
//                    maxLen = curLen
//                }
//                if (i == nums.size - 1) {
//                    curLen = 1
//                } else {
//                    curLen = 0
//                }
            } else {
                 // reset sequence
                curLen = 0
            }
            if (maxLen < curLen) {
                maxLen = curLen
            }
        }

        return maxLen
    }
}

fun main() {
    println(Problem2419().longestSubarray(intArrayOf(1, 2, 3, 3, 2, 2)))
    println(Problem2419().longestSubarray(intArrayOf(1, 2, 3, 4)))
    println(Problem2419().longestSubarray(intArrayOf(10, 2, 2, 2, 3, 3, 5, 5)))
}