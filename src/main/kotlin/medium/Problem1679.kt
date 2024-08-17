package medium

class Problem1679 {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val count = hashMapOf<Int, Int>()
        var ops = 0

        nums.forEach { v ->
            val rem = k - v
            if (count[rem] != null && count[rem]!! > 0) {
                count[rem] = (count[rem]!!) - 1
                ops++
            } else {
                count[v] = (count[v] ?: 0) + 1
            }
        }
        return ops
    }
}

fun main() {
    println(Problem1679().maxOperations(intArrayOf(1, 2, 3, 4), 5))
    println(Problem1679().maxOperations(intArrayOf(3, 1, 3, 4, 3), 6))
    println(Problem1679().maxOperations(intArrayOf(2, 2, 2, 3, 1, 1, 4, 1), 4))

}