package grind75

/**
 * Created by Hardik Srivastava on 13/10/25
 */
// https://leetcode.com/problems/two-sum/
class Problem1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (nums.size == 2) {
            return intArrayOf(0, 1)
        }

        val map = hashMapOf<Int, Int>()

        nums.forEachIndexed { index, i ->
            val rem = target - i
            if (map[rem] != null) {
                return intArrayOf(map[rem]!!, index)
            }
            map[i] = index
        }

        return intArrayOf(0, 1)
    }
}

fun main() {
    println(Problem1().twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString())
    println(Problem1().twoSum(intArrayOf(3, 2, 4), 6).joinToString())
    println(Problem1().twoSum(intArrayOf(3, 3), 6).joinToString())
}