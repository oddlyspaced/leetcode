package medium

class Problem1574 {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        val left = (1..<arr.size).firstOrNull { arr[it] < arr[it - 1] } ?: return 0
        var right = (1..<arr.size).last { arr[it] < arr[it - 1] }
        var res = minOf(arr.size - left, right)
        for (l in 0..<left) {
            // check for sort logic
            while (right < arr.size && arr[right] < arr[l]) {
                right++
            }
            res = minOf(res, right - l - 1)
        }
        return res
    }
}

fun main() {
    println(Problem1574().findLengthOfShortestSubarray(intArrayOf(1, 2, 3, 10, 4, 2, 3, 5)))
    println(Problem1574().findLengthOfShortestSubarray(intArrayOf(5, 4, 3, 2, 1)))
    println(Problem1574().findLengthOfShortestSubarray(intArrayOf(1, 2, 3)))
}