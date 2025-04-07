package medium

/**
 * Created by Hardik Srivastava on 06/04/25
 */
class Problem368 {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        nums.sort()
        val dp = IntArray(nums.size) { 1 }
        val prev = IntArray(nums.size) { -1 }
        var maxI = 0
        for (i in 1..<nums.size) {
            for (j in 0..<i) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1
                    prev[i] = j
                }
            }
            if (dp[i] > dp[maxI]) {
                maxI = i
            }
        }
        val res = arrayListOf<Int>()
        var i = maxI
        while (i >= 0) {
            res.add(nums[i])
            i = prev[i]
        }
        return res
    }
}

fun main() {
//    println(Problem368().largestDivisibleSubset(intArrayOf(1, 2, 3)))
//    println(Problem368().largestDivisibleSubset(intArrayOf(1, 2, 4, 8)))
//    println(Problem368().largestDivisibleSubset(intArrayOf(3, 17)))
    println(Problem368().largestDivisibleSubset(intArrayOf(3, 4, 16, 8)))
}