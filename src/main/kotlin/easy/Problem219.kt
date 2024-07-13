package easy

class Problem219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val window = mutableSetOf<Int>()
        for (i in nums.indices) {
            val v = nums[i]
            if (window.contains(v)) {

            }
        }
        return false
    }
}

fun main() {
    println(Problem219().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
}