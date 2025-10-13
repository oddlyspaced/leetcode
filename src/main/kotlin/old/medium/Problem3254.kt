package old.medium

class Problem3254 {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        fun check(start: Int): Int {
            var m = nums[start]
            for (i in (start + 1)..<(start + k)) {
                if (nums[i] != (nums[i - 1] + 1)) {
                    return -1
                }
                m = maxOf(m, nums[i])
            }
            return m
        }

        val res = IntArray(nums.size - k + 1)
        var index = 0
        for (i in 0..(nums.size - k)) {
            res[index++] = check(i)
        }
        return res
    }
}

fun main() {
    println(Problem3254().resultsArray(intArrayOf(1, 2, 3, 4, 3, 2, 5), 3).joinToString(","))
    println(Problem3254().resultsArray(intArrayOf(2, 2, 2, 2, 2), 4).joinToString(","))
    println(Problem3254().resultsArray(intArrayOf(3, 2, 3, 2, 3, 2), 2).joinToString(","))
}