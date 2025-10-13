package old.hard

class Problem41 {
    fun firstMissingPositive(nums: IntArray): Int {
        // find sum of all positive numbers

        if (nums.size ==  1) {
            return if (nums[0] > 1 || nums[0] == 0) 1 else 2
        }

        val res = IntArray(nums.size)
        for (i in nums.indices) {
            if (nums[i] > 0 && nums[i] < nums.size) {
                res[nums[i]] = nums[i]
            }
        }
        var i = 1
        while (i < res.size && res[i] == i) {
            i++
        }
        println("RES : ${res.joinToString(",")}")
        return i
    }
}

fun main() {
//    println(Problem41().firstMissingPositive(intArrayOf(3, 4, -1, 1)))
//    println(Problem41().firstMissingPositive(intArrayOf(0, 2, 1)))
    println(Problem41().firstMissingPositive(intArrayOf(1, 2, 0)))
    println(Problem41().firstMissingPositive(intArrayOf(1)))
//    println(Problem41().firstMissingPositive(intArrayOf(7, 6, 5, 11, 12)))
//    println(Problem41().firstMissingPositive(intArrayOf(7, 6, 5, 11, 1, 12, 2)))
//    println(Problem41().firstMissingPositive(intArrayOf(5, 2)))
}