package old.medium

class Problem334 {
    fun increasingTriplet(nums: IntArray): Boolean {
        var cur1 = Int.MAX_VALUE
        var cur2 = Int.MAX_VALUE

        for (i in nums.indices) {
            if (nums[i] <= cur1) {
                cur1 = nums[i]
            } else if (nums[i] <= cur2) {
                cur2 = nums[i]
            } else {
                return true
            }
        }
        return false
    }
}

fun main() {
    println(Problem334().increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))
    println(Problem334().increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))
    println(Problem334().increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))
    println(Problem334().increasingTriplet(intArrayOf(20, 100, 10, 12, 5, 13)))
}