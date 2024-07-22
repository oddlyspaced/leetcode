package easy

class Problem704 {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val mid = (l + r) / 2
            if (nums[mid] == target) {
                return mid
            } else if (target < nums[mid]) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return -1
    }
}

fun main() {
    println(Problem704().search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    println(Problem704().search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
    println(Problem704().search(intArrayOf(5), 5))
}