package medium

import easy.ListNode
import kotlin.math.min

class Problem2807 {
    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */

    private fun gcd(a: Int, b: Int): Int {
        var result: Int = min(a, b)
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break
            }
            result--
        }
        return result
    }

    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        val copy = head
        var head = head
        while (head?.next != null) {
            val l = ListNode(gcd(head.`val`, head.next!!.`val`))
            l.next = head.next
            head.next = l
            head = l.next
        }
        return copy
    }
}

fun main() {
    val listValues = intArrayOf(18, 6, 10, 3)
    var list: ListNode? = ListNode(listValues[0])
    val listStart = list
    for (i in 1..<listValues.size) {
        list?.next = ListNode(listValues[i])
        list = list?.next
    }

    var res = Problem2807().insertGreatestCommonDivisors(listStart)
    while (res != null) {
        println(res.`val`)
        res = res.next
    }
}