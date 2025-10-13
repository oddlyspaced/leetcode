package old.medium

class Problem3097 {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        var res = Int.MAX_VALUE
        val bits = IntArray(32)

        fun bitsUpdate(bits: IntArray, n: Int, diff: Int) {
            for (i in 0..<32) {
                if ((n and (1 shl i)) != 0) {
                    bits[i] += diff
                }
            }
        }

        fun bitsToInt(bits: IntArray): Int {
            var r = 0
            for (i in 0..<32) {
                if (bits[i] > 0) {
                    r += (1 shl i)
                }
            }
            return r
        }

        var l = 0
        for (r in nums.indices) {
            bitsUpdate(bits, nums[r], 1)
            var curOr = bitsToInt(bits)
            while (l <= r && curOr >= k) {
                res = minOf(res, (r - l + 1))
                bitsUpdate(bits, nums[l], -1)
                curOr = bitsToInt(bits)
                l++
            }
        }
        return if (res == Int.MAX_VALUE) -1 else res
    }
}

fun main() {
    println(Problem3097().minimumSubarrayLength(intArrayOf(1, 2, 3), 2))
}