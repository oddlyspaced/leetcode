package old.medium

class Problem3355 {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val line = IntArray(nums.size + 1)
        queries.forEach {
            line[it[0]]++
            line[it[1] + 1]--
        }
        for (i in 1..<line.size) {
            line[i] += line[i - 1]
        }
        for (i in nums.indices) {
            if (line[i] < nums[i]) {
                return false
            }
        }
        return true
    }
}