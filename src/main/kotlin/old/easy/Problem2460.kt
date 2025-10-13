package old.easy

class Problem2460 {
    fun applyOperations(nums: IntArray): IntArray {
        for (i in 0..<nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2
                nums[i + 1] = 0
            }
        }
        val res = IntArray(nums.size)
        var cur = 0
        nums.forEach {
            if (it > 0) {
                res[cur++] = it
            }
        }
        return res
    }
}

fun main() {
    println(Problem2460().applyOperations(intArrayOf(1, 2, 2, 1, 1, 0)).joinToString(", "))
    println(Problem2460().applyOperations(intArrayOf(0, 1)).joinToString(", "))
    println(
        Problem2460().applyOperations(intArrayOf(847, 847, 0, 0, 0, 399, 416, 416, 879, 879, 206, 206, 206, 272))
            .joinToString(", ")
    )
}