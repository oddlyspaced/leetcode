package medium

class Problem2270 {
    fun waysToSplitArray(nums: IntArray): Int {
        val nums = nums.map { it.toLong() }
        val sum: Long = nums.sum()
        var leftSum = 0L
        var rightSum = sum
        var counter = 0
        for (i in 0..<nums.size - 1) {
            leftSum += nums[i]
            rightSum -= nums[i]
            if (leftSum >= rightSum) {
                counter++
            }
        }
        return counter
    }
}

fun main() {
    println(Problem2270().waysToSplitArray(intArrayOf(10, 4, -8, 7)))
    println(Problem2270().waysToSplitArray(intArrayOf(2, 3, 1, 0)))
    println(Problem2270().waysToSplitArray(intArrayOf(0, 0)))
}