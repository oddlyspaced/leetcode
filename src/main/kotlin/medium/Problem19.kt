package medium

import easy.ListNode

class Problem19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        // todo
        return null
    }
}

fun main() {
    val root = ListNode(1)
    root.next = ListNode(2)
    root.next?.next = ListNode(3)
    root.next?.next?.next = ListNode(4)
    root.next?.next?.next?.next = ListNode(5)

    var r = Problem19().removeNthFromEnd(root, 2)
    while (r != null) {
        print(r.`val`)
        print(", ")
        r = r.next
    }
}