package old.medium

class Problem209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var start = 0
        var index = 0
        var sum = 0
        var minL = Int.MAX_VALUE
        while (index < nums.size) {
            sum += nums[index]
            if (sum >= target) {
                if (minL > (index - start)) {
                    minL = (index - start)
                }
                sum = 0
                start = index
            }
            index++
        }
        if (minL == Int.MAX_VALUE) {
            return 0
        }
        return minL
    }
}

fun main() {
//    println(Problem209().minSubArrayLen(target = 7, intArrayOf(2, 3, 1, 2, 4, 3)))
//    println(Problem209().minSubArrayLen(target = 11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)))
    println(Problem209().minSubArrayLen(target = 11, intArrayOf(1, 2, 3, 4, 5)))
}