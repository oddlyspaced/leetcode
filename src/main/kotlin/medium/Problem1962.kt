package medium

import java.util.*

class Problem1962 {
    fun minStoneSum(piles: IntArray, k: Int): Int {
        val pq = PriorityQueue<Int>(piles.size) { i, j ->
            j - i
        }
        piles.forEach {
            pq.add(it)
        }
        repeat(k) {
            val t = pq.poll()
            pq.add(t - (t / 2))
        }
        return pq.sum()
    }
}

fun main() {
    println(Problem1962().minStoneSum(intArrayOf(5, 4, 9), 2))
}