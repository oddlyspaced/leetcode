package old.easy

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(val `val`: Int) {
    var next: ListNode? = null
}

class Problem21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        // list1 = [1, 2, 4], list2 = [1, 3, 4]
        var list1V: ListNode? = list1
        var list2V: ListNode? = list2
        var mergedList: ListNode? = ListNode(-1)
        val mergedListC = mergedList

        while (list1V != null || list2V != null) {
            if (list1V != null && list2V != null) {
                if (list1V.`val` < list2V.`val`) {
                    mergedList?.next = ListNode(list1V.`val`)
                    mergedList = mergedList?.next
                    list1V = list1V.next
                } else {
                    mergedList?.next = ListNode(list2V.`val`)
                    mergedList = mergedList?.next
                    list2V = list2V.next
                }
            } else if (list1V == null && list2V != null) {
                mergedList?.next = ListNode(list2V.`val`)
                mergedList = mergedList?.next
                list2V = list2V.next

            } else if (list1V != null && list2V == null) {
                mergedList?.next = ListNode(list1V.`val`)
                mergedList = mergedList?.next
                list1V = list1V.next
            }
        }
        return mergedListC?.next
    }
}

fun main() {
//   list1 = [1, 2, 4], list2 = [1, 3, 4]
    val list1Values = intArrayOf(1, 2, 4)
    var list1: ListNode? = ListNode(list1Values[0])
    val list1Start = list1
    for (i in 1..<list1Values.size) {
        list1?.next = ListNode(list1Values[i])
        list1 = list1?.next
    }

    val list2Values = intArrayOf(1, 3, 4)
    var list2: ListNode? = ListNode(list2Values[0])
    val list2Start = list2
    for (i in 1..<list2Values.size) {
        list2?.next = ListNode(list2Values[i])
        list2 = list2?.next
    }

    var res = Problem21().mergeTwoLists(list1Start, list2Start)
    while (res != null) {
        println(res.`val`)
        res = res.next
    }
}