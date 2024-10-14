package medium

import java.util.PriorityQueue
import kotlin.math.ceil

class Problem2530 {
    fun maxKelements(nums: IntArray, k: Int): Long {
        val pq = PriorityQueue<Int>(nums.size) { i, j ->
            j - i
        }
        nums.forEach {
            pq.add(it)
        }

        var res = 0L
        repeat(k) {
            val t = pq.poll()
            res += t
            pq.add(ceil(t / 3.0).toInt())
        }

        return res
    }
}

fun main() {
    println(Problem2530().maxKelements(intArrayOf(1, 10, 3, 3, 3), 3))
}