package medium

class Problem55 {
    fun canJump(nums: IntArray): Boolean {
        if (nums[0] == 0) {
            return false
        }
        var index = 1
        while (index < nums.size) {
            val jump = nums[index]
            if (index == nums.size - 1) {
                return true
            }
            if (jump == 0) {
                return false
            }
            println(index)
            index += jump
        }
        println(index)
        return index >= nums.size
    }
}

fun main() {
    println(Problem55().canJump(intArrayOf(2, 3, 1, 1, 4)))
    println(Problem55().canJump(intArrayOf(3, 2, 1, 0, 4)))
    println(Problem55().canJump(intArrayOf(1)))
    println(Problem55().canJump(intArrayOf(2, 0)))
    println(Problem55().canJump(intArrayOf(1, 3, 2)))
    println(Problem55().canJump(intArrayOf(2, 5, 0, 0)))
    println(Problem55().canJump(intArrayOf(0, 1)))
}