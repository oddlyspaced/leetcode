package old.medium

class Problem2134 {
    fun minSwaps(nums: IntArray): Int {
        val count1 = nums.count { it == 1 }
        var l = 0
        var windowCount = 0
        var maxCount = 0

        for (r in 0..<(nums.size * 2)) {
            if (nums[r % nums.size] == 1) {
                windowCount++
            }
            if (r - l + 1 > count1) {
                windowCount -= nums[l % nums.size]
                l += 1
            }
            maxCount= maxOf(maxCount, windowCount)
        }

        return count1 - maxCount


//        // find working area first
//        var rS = 0
//        var rE = nums.size - 1
//        var r1 = 0
//        var index = 0
//        while (true) {
//            if (rS == rE) {
//                return 0
//            }
//            if (nums[rS] == 0 && nums[rE] == 0) {
//                rS++
//                rE--
//            } else if (nums[rS] == 1 && nums[rE] == 1) {
//                r1++
//                rS++
//                rE--
//            } else {
//                break
//            }
//        }
//
//        var total = 0
//
//        var start = -1
//        var end = -1
//
//        var i = rS
//        while (i <= rE) {
//            if (nums[i] == 1) {
//                total++
//                if (start == -1) {
//                    start = i
//                }
//                end = i
//            }
//            i++
//        }
//
//        if (r1 > 0 && total > 1) {
//            return (end - start + 1) - total + r1
//        }
//        return (end - start + 1) - total
    }
}

fun main() {
    println(Problem2134().minSwaps(intArrayOf(0, 1, 0, 1, 1, 0, 0)))
    println(Problem2134().minSwaps(intArrayOf(0, 1, 1, 1, 0, 0, 1, 1, 0)))
    println(Problem2134().minSwaps(intArrayOf(1, 1, 0, 0, 1)))
    println("---")
    println(Problem2134().minSwaps(intArrayOf(1, 1, 0, 1, 1)))
    println(Problem2134().minSwaps(intArrayOf(1, 0, 0, 1, 1)))
}