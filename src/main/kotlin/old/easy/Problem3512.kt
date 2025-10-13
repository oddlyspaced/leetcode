package old.easy

/**
 * Created by Hardik Srivastava on 20/04/25
 */
class Problem3512 {
    fun minOperations(nums: IntArray, k: Int): Int {
        return nums.sum() % k
    }
}

fun main() {
    println(Problem3512().minOperations(intArrayOf(3, 9, 7), 5))
    println(Problem3512().minOperations(intArrayOf(4, 1, 3), 4))
    println(Problem3512().minOperations(intArrayOf(3, 2), 6))
}