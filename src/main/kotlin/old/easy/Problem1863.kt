package old.easy

/**
 * Created by Hardik Srivastava on 06/04/25
 */
class Problem1863 {
    private fun subset(nums: IntArray): Int {
        var result = 0
        fun backtrack(index: Int, currentXor: Int) {
            if (index == nums.size) {
                result += currentXor
                return
            }
            backtrack(index + 1, currentXor xor nums[index])
            backtrack(index + 1, currentXor)
        }
        backtrack(0, 0)
        return result
    }

    fun subsetXORSum(nums: IntArray): Int {
        return subset(nums)
    }
}

fun main() {
    println(Problem1863().subsetXORSum(intArrayOf(1, 3)))
}