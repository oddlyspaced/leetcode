package old.easy

/**
 * Created by Hardik Srivastava on 02/04/25
 */
class Problem2873 {
    fun maximumTripletValue(nums: IntArray): Long {
        val minPrefix = IntArray(nums.size)
        minPrefix[0] = nums[0];
        for (i in 1..<nums.size) {
            minPrefix[i] = maxOf(minPrefix[i - 1], nums[i - 1])
        }
        val maxSuffix = IntArray(nums.size)
        maxSuffix[nums.size - 1] = nums[nums.size - 1]
        for (i in (nums.size - 2) downTo 0) {
            maxSuffix[i] = maxOf(maxSuffix[i + 1], nums[i + 1])
        }
        var res = 0L
        for (j in 1..<nums.size - 1) {
            if (minPrefix[j] > nums[j]) {
                res = maxOf(res, (minPrefix[j] - nums[j]) * maxSuffix[j].toLong());
            }
        }
        return res
    }
}

fun main() {
    println(Problem2873().maximumTripletValue(intArrayOf(12, 6, 1, 2, 7)))
    println(Problem2873().maximumTripletValue(intArrayOf(1, 10, 3, 4, 19)))
    println(Problem2873().maximumTripletValue(intArrayOf(1, 2, 3)))
    println(Problem2873().maximumTripletValue(intArrayOf(1000000, 1, 1000000)))
}