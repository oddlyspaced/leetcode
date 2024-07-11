package medium

import easy.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */


class Problem2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) {
            return null
        } else if (l1 == null && l2 != null) {
            return l2
        } else if (l1 != null && l2 == null) {
            return l1
        }

        if (l1?.`val` == 0 && l1.next == null) {
            return l2
        }
        else if (l2?.`val` == 0 && l2.next == null) {
            return l1
        }
        else if (l1?.`val` == 0 && l2?.`val` == 0 && l1.next == null && l2.next == null) {
            return l1
        }

        val start: ListNode? = ListNode(0)
        var result = start
        var l1 = l1
        var l2 = l2

        var carry = 0
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                var res = l1.`val` + l2.`val` + carry
                carry = 0
                if (res > 9) {
                    res -= 10
                    carry = 1
                }
                result?.next = ListNode(res)
                result = result?.next
                l1 = l1.next
                l2 = l2.next
            } else if (l1 != null) {
                var res = l1.`val` + carry
                carry = 0
                if (res > 9) {
                    res -= 10
                    carry = 1
                }
                result?.next = ListNode(res)
                result = result?.next
                l1 = l1.next
            } else if (l2 != null) {
                var res = l2.`val` + carry
                carry = 0
                if (res > 9) {
                    res -= 10
                    carry = 1
                }
                result?.next = ListNode(res)
                result = result?.next
                l2 = l2.next
            }
        }
        if (result?.`val` == 0 || carry == 1) {
            result?.next = ListNode(1)
        }
        return start?.next
    }
}

fun main() {
    // l1 = [2,4,3], l2 = [5,6,4]
    val list1Values = intArrayOf(9)
    var list1: ListNode? = ListNode(list1Values[0])
    val list1Start = list1
    for (i in 1..<list1Values.size) {
        list1?.next = ListNode(list1Values[i])
        list1 = list1?.next
    }

    val list2Values = intArrayOf(9)
    var list2: ListNode? = ListNode(list2Values[0])
    val list2Start = list2
    for (i in 1..<list2Values.size) {
        list2?.next = ListNode(list2Values[i])
        list2 = list2?.next
    }

    var res = Problem2().addTwoNumbers(list1Start, list2Start)
    println()
    while (res != null) {
        print(res.`val`)
        res = res.next
    }
}