package hard

import java.util.*


class Problem862 {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        val n = nums.size
        val prefixSums = LongArray(n + 1).apply {
            for (i in 1..n) {
                this[i] = this[i - 1] + nums[i - 1].toLong()
            }
        }

        var result = Int.MAX_VALUE
        val deque = ArrayDeque<Int>()

        prefixSums.forEachIndexed { index, currentPrefix ->
            while (deque.isNotEmpty() && currentPrefix - prefixSums[deque.first()] >= k) {
                result = minOf(result, index - deque.removeFirst())
            }

            while (deque.isNotEmpty() && currentPrefix <= prefixSums[deque.last()]) {
                deque.removeLast()
            }

            deque.add(index)
        }

        return if (result == Int.MAX_VALUE) -1 else result

    }
}

fun main() {
    println(Problem862().shortestSubarray(intArrayOf(2, -1, 2), 3))
}