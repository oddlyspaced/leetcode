package old.easy

import java.util.PriorityQueue

class KthLargest(var k: Int, nums: IntArray) {
    private val q = PriorityQueue<Int>(3)

    init {
        nums.forEach {
            add(it)
        }
    }

    fun add(`val`: Int): Int {
        q.offer(`val`)
        if (q.size > k) {
            q.poll()
        }
        return q.peek()
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */

fun main() {
    val obj = KthLargest(3, intArrayOf())
    println(obj.add(3))
    println(obj.add(5))
    println(obj.add(10))
    println(obj.add(9))
    println(obj.add(4))
}