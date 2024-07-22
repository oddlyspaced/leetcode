package medium

class Problem238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        var total = 1
        nums.forEach {
            total *= it
        }
        val res = IntArray(nums.size)
        nums.forEachIndexed { index, v ->
            res[index] = total / v
        }
        return res
    }
}

fun main() {
    println(Problem238().productExceptSelf(intArrayOf(1, 2, 3, 4)).joinToString(","))
}