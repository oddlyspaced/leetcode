package grind75

/**
 * Created by Hardik Srivastava on 15/10/25
 */
// https://leetcode.com/problems/merge-two-sorted-lists/
class Problem21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var head = ListNode(-1)
        val copy = head
        var list1 = list1
        var list2 = list2
        while (list1 != null && list2 != null) {
            if (list1.`val` < list2.`val`) {
                head.next = ListNode(list1.`val`)
                head = head.next!!
                list1 = list1.next
            }
            else {
                head.next = ListNode(list2.`val`)
                head = head.next!!
                list2 = list2.next
            }
        }
        while (list1 != null) {
            head.next = ListNode(list1.`val`)
            head = head.next!!
            list1 = list1.next
        }
        while (list2 != null) {
            head.next = ListNode(list2.`val`)
            head = head.next!!
            list2 = list2.next
        }
        return copy.next
    }
}

fun main() {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next?.next = ListNode(4)
    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next?.next = ListNode(4)
    var res = Problem21().mergeTwoLists(l1, l2)
    while (res != null) {
        println(res.`val`)
        res = res.next
    }
}