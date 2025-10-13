package old.medium

class Problem2149 {
    fun rearrangeArray(nums: IntArray): IntArray {
        val pos = IntArray(nums.size / 2)
        val neg = IntArray(nums.size / 2)
        var indexPos = 0
        var indexNeg = 0
        for (v in nums) {
            if (v >= 0) {
                pos[indexPos++] = v
            } else {
                neg[indexNeg++] = v
            }
        }
        val res = IntArray(nums.size)
        var index = 0
        for (i in pos.indices) {
            res[index++] = pos[i]
            res[index++] = neg[i]
        }
        return res
    }
}

fun main() {
    println(Problem2149().rearrangeArray(intArrayOf(3, 1, -2, -5, 2, -4)).joinToString(","))
    println(Problem2149().rearrangeArray(intArrayOf(-1, 1)).joinToString(","))
}