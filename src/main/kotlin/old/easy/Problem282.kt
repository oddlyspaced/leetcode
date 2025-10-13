package old.easy

class Problem282 {
    fun moveZeroes(nums: IntArray): Unit {
        println(nums.joinToString(","))
        var index = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                val t = nums[i]
                nums[i] = nums[index]
                nums[index] = t
                index++
            }
        }
        println(nums.joinToString(","))
    }
}

fun main() {
    Problem282().moveZeroes(intArrayOf(0, 1, 0, 3, 12))
}