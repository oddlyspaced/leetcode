package medium

import easy.ListNode

class Problem725 {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        var totalNodes = 0
        var headCopy = head
        while (headCopy != null) {
            totalNodes++
            headCopy = headCopy.next
        }

        println("TOTAL : $totalNodes")
        if (totalNodes < k) {
            headCopy = head
            // handle this case separately
            val res = Array(k) {
                val c = headCopy
                headCopy = headCopy?.next
                if (c != null) {
                    ListNode(c.`val`)
                } else {
                    null
                }
            }
            return res
        } else {
            // each result item will haqxve at least these many nodes
            val each = totalNodes / k
            val resCount = IntArray(k) { each }
            var rem = totalNodes % k
            var index = 0
            while (rem > 0) {
                resCount[index++] += 1
                rem--
            }
            headCopy = head
            println("R : " + resCount.joinToString(","))
            val res = Array<ListNode?>(k) { null }
            for (i in res.indices) {
                println("ADDING NODE VAL : " + headCopy!!.`val`)
                var resNode = ListNode(headCopy!!.`val`)
                val resNodeCopy = resNode
                repeat(resCount[i]) {
                    headCopy = headCopy?.next
                    if (it != resCount[i] - 1) {
                        if (headCopy != null) {
                            resNode.next = ListNode(headCopy!!.`val`)
                            resNode = resNode.next!!
                        }
                    }
                }
                res[i] = resNodeCopy
            }
            return res
        }
    }
}

fun main() {
//    val head = ListNode(1)
//    var headCopy: ListNode? = head
//    (2..10).forEach {
//        headCopy?.next = ListNode(it)
//        headCopy = headCopy?.next
//    }
//    Problem725().splitListToParts(head, 3).forEach {
//        var c = it
//        while (c != null) {
//            print("${c.`val`},")
//            c = c.next
//        }
//        println()
//    }

//    val head = ListNode(1)
//    var headCopy: ListNode? = head
//    (2..3).forEach {
//        headCopy?.next = ListNode(it)
//        headCopy = headCopy?.next
//    }
//    Problem725().splitListToParts(head, 5).forEach {
//        println(it?.`val`)
//    }

    val head = ListNode(0)
    var headCopy: ListNode? = head
    intArrayOf(1, 2, 3, 4).forEach {
        headCopy?.next = ListNode(it)
        headCopy = headCopy?.next
    }
    Problem725().splitListToParts(head, 3).forEach {
        var c = it
        while (c != null) {
            print("${c.`val`},")
            c = c.next
        }
        println()
    }

}