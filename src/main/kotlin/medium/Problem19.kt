package medium

import easy.ListNode

class Problem19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val ret = head
        var copy = head
        var del: ListNode? = ListNode(-1)
        del?.next = head
        var dist = 1
        while (dist <= n) {
            copy = copy?.next
            dist++
        }
        while (copy != null) {
            del = del?.next
//            repeat(n) {/
                copy = copy.next
//            }
        }
        println("DEL : ${del?.`val`}")
        del?.next = del?.next?.next
        return ret
    }
}

fun main() {
    val root = ListNode(1)
//    root.next = ListNode(2)
//    root.next?.next = ListNode(3)
//    root.next?.next?.next = ListNode(4)
//    root.next?.next?.next?.next = ListNode(5)

    var r = Problem19().removeNthFromEnd(root, 1)
    while (r != null) {
        print(r.`val`)
        print(", ")
        r = r.next
    }
}