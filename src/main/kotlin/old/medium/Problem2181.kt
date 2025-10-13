package old.medium

import easy.ListNode

class Problem2181 {
    fun mergeNodes(head: ListNode?): ListNode? {
        var head = head?.next
        val resHead: ListNode? = ListNode(0)
        var res = resHead
        var temp = 0
        while (head != null) {
            if (head.`val` == 0) {
                // add to result
                res?.next = ListNode(temp)
                res = res?.next
                temp = 0
            } else {
                temp += head.`val`
            }
            head = head.next
        }
        return resHead?.next
    }
}

fun main() {
    val listValues = intArrayOf(0, 3, 1, 0, 4, 5, 2, 0)
    var list: ListNode? = ListNode(listValues[0])

    val listStart = list
    for (i in 1..<listValues.size) {
        list?.next = ListNode(listValues[i])
        list = list?.next
    }

    var res = Problem2181().mergeNodes(listStart)
    while (res != null) {
        println(res.`val`)
        res = res.next
    }
}