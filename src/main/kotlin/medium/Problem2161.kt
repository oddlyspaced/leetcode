package medium

class Problem2161 {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        var l = 0
        var r = nums.size - 1
        val res = IntArray(nums.size)
        for (i in nums.indices) {
            if (nums[i] < pivot) {
                res[l++] = nums[i]
            }
            if (nums[nums.size - 1 - i] > pivot) {
                res[r--] = nums[nums.size - 1 - i]
            }
        }
        while (l <= r) {
            res[l++] = pivot
            res[r--] = pivot
        }
        return res
    }
}

fun main() {
    println(Problem2161().pivotArray(intArrayOf(9, 12, 5, 10, 14, 3, 10), 10).joinToString(", "))
    println(Problem2161().pivotArray(intArrayOf(-3, 4, 3, 2), 2).joinToString(", "))
}