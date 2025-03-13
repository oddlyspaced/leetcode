package medium

class Problem3356 {
    // https://www.youtube.com/watch?v=Ap8NIgIqM2A&t=28s&ab_channel=Techdose
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        val diff = IntArray(nums.size + 1)
        var sum = 0
        var pos = 0
        for (i in nums.indices) {
            while (sum + diff[i] < nums[i]) {
                if (pos == queries.size) {
                    return -1
                }
                val start = queries[pos][0]
                val end = queries[pos][1]
                val value = queries[pos][2]
                pos++
                if (end < i) {
                    continue
                }
                diff[maxOf(start, i)] += value
                diff[end + 1] -= value
            }
            sum += diff[i]
        }
        return pos
    }
}

fun main() {
    println(
        Problem3356().minZeroArray(
            intArrayOf(2, 0, 2), arrayOf(
                intArrayOf(0, 2, 1), intArrayOf(0, 2, 1), intArrayOf(1, 1, 3)
            )
        )
    )
}