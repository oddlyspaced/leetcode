package old.hard

import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min

class Problem632 {
    fun smallestRange(nums: List<List<Int>>): IntArray {
        val k = nums.size
        var left = nums.first().first()
        var right = left

        val minHeap = PriorityQueue<IntArray>() { i, j ->
            i[0] - j[0]
        }

        for (i in 0..<k) {
            val l = nums[i]
            left = min(left, l.first())
            right = max(right, l.first())
            minHeap.add(intArrayOf(l.first(), i, 0))
        }

        var res = intArrayOf(left, right)

        while (true) {
            val t = minHeap.remove()
            val n = t[0]
            val i = t[1]
            var idx = t[2]

            idx += 1

            if (idx == nums[i].size) {
                return res
            }

            val nextVal = nums[i][idx]
            minHeap.add(intArrayOf(nextVal, i, idx))
            right = max(right, nextVal)
            left = minHeap.first().first()
            if (right - left < res[1] - res[0]) {
                res = intArrayOf(left, right)
            }

        }
        return res
    }
}

fun main() {
    println(
        Problem632().smallestRange(
            listOf(
                listOf(4, 10, 15, 24, 26),
                listOf(0, 9, 12, 20),
                listOf(5, 18, 22, 30)
            )
        ).joinToString(",")
    )
}