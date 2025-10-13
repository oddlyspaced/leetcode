package old.medium

class Problem198 {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var prev1 = 0
        var prev2 = 0
        nums.forEach {
            val temp = prev1
            prev1 = maxOf(prev2 + it, prev1)
            prev2 = temp
        }
        return prev1
    }
}

fun main() {
    println(Problem198().rob(intArrayOf(1, 2, 3, 1)))
    println(Problem198().rob(intArrayOf(2, 7, 9, 3, 1)))
}