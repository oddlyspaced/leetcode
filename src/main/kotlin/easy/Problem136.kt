package easy

class Problem136 {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            //due to the properties of XOR, pairs of numbers will cancel each other out, and only the unique number will remain in result.
            result = result xor num
        }
        return result
    }
}

fun main() {
    // 4,1,2,1,2
    println(Problem136().singleNumber(intArrayOf(2, 2, 1)))
}