package old.medium

/**
 * Created by Hardik Srivastava on 07/04/25
 */
class Problem416 {
    fun canPartition(nums: IntArray): Boolean {
        val total = nums.sum()
        if (total % 2 == 1) {
            return false
        }
        val target = total / 2
        val store = BooleanArray(target + 1)
        store[0] = true
        nums.forEach {
            var currentSum = target
            while (currentSum >= it) {
                store[currentSum] = store[currentSum] || store[currentSum - it]
                currentSum--
            }
        }
        return store[target]
    }
}

fun main() {
    println(Problem416().canPartition(intArrayOf(1, 5, 11, 5)))
}