package old.medium

import old.easy.ListNode

class Problem3217 {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val values = nums.toSet()
        var res: ListNode? = ListNode(-1)
        res?.next = head
        val copy = res

        while (res != null) {
            if (values.contains(res.next?.`val`)) {
                res.next = res.next?.next
            } else {
                res = res.next
            }
        }
        return copy?.next
    }
}

fun main() {
//    val res = ListNode(1)
//    res.next = ListNode(2)
//    res.next?.next = ListNode(3)
//    res.next?.next?.next = ListNode(4)
//    res.next?.next?.next?.next = ListNode(5)
//
//    var result = Problem3217().modifiedList(intArrayOf(1, 2, 3), res)
//


    val res = ListNode(1)
    res.next = ListNode(2)
    res.next?.next = ListNode(1)
    res.next?.next?.next = ListNode(2)
    res.next?.next?.next?.next = ListNode(1)
    res.next?.next?.next?.next?.next = ListNode(2)

    var result = Problem3217().modifiedList(intArrayOf(1), res)
    while (result != null) {
        println(result.`val`)
        result = result.next
    }

}