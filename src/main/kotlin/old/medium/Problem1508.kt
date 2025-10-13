package old.medium

class Problem1508 {
    fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {

        val prefix = IntArray(n + 1)
        for (i in 1..n) {
            prefix[i] = prefix[i - 1] + nums[i - 1]
        }

        println("PREF : ${prefix.joinToString(",")}")


        val subarray = IntArray(n * (n + 1) / 2)
        var index = 0

        for (i in nums.indices) {
            var sum = nums[i]
            subarray[index++] = sum
            for (j in (i + 1)..<nums.size) {
                sum += nums[j]
                subarray[index++] = sum
            }
        }

        var sum = 0
        repeat(right) { i ->
            for (j in (i + 1)..<subarray.size) {
                if (subarray[i] > subarray[j]) {
                    val t = subarray[i]
                    subarray[i] = subarray[j]
                    subarray[j] = t
                }
            }
        }

        for (i in (left - 1)..<right) {
            sum += subarray[i]
        }

        return sum % (1000000007)
    }
}

fun main() {
    println(Problem1508().rangeSum(intArrayOf(1, 2, 3, 4), 4, 1, 5))
    println(Problem1508().rangeSum(intArrayOf(1, 2, 3, 4), 4, 3, 4))
    println(Problem1508().rangeSum(intArrayOf(1, 2, 3, 4), 4, 1, 10))
}