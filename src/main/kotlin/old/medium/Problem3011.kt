package old.medium

class Problem3011 {
    fun canSortArray(nums: IntArray): Boolean {
        var currentBits = 0
        var curMax = 0
        var prevMax = 0
        nums.forEach {
            val bits = it.countOneBits()
            if (bits != currentBits) {
                currentBits = bits
                prevMax = curMax
            }
            // current number should not be smaller than prev max
            if (it < prevMax) {
                return false
            }
            curMax = maxOf(curMax, it)
        }
        return true
    }
}

fun main() {
    println(Problem3011().canSortArray(intArrayOf(8, 4, 2, 30, 15)))
    println(Problem3011().canSortArray(intArrayOf(1, 2, 3, 4, 5)))
    println(Problem3011().canSortArray(intArrayOf(3, 16, 8, 4, 2)))
    println(Problem3011().canSortArray(intArrayOf(160, 247, 127)))
    println(Problem3011().canSortArray(intArrayOf(20, 16)))
}