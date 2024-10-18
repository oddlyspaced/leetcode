package easy

class Problem3190 {
    fun minimumOperations(nums: IntArray): Int {
        var ops = 0
        nums.forEach {
            val rem = it % 3
            if (rem != 0) {
                ops++
            }
        }
        return ops
    }
}

fun main() {
    println(Problem3190().minimumOperations(intArrayOf(1, 2, 3, 4)))
    println(Problem3190().minimumOperations(intArrayOf(3, 6, 9)))
}