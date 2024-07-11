package easy

class Problem83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val copy = head
        var head = head
        while (head != null) {
            if (head.`val` == head.next?.`val`) {
                head.next = head.next?.next
            }
            else {
                head = head.next
            }
        }
        return copy
    }
}

fun main() {
    val list1Values = intArrayOf(1, 1, 1, 2, 2, 3, 3, 3, 4)
    var list1: ListNode? = ListNode(list1Values[0])
    val list1Start = list1
    for (i in 1..<list1Values.size) {
        list1?.next = ListNode(list1Values[i])
        list1 = list1?.next
    }

    var res = Problem83().deleteDuplicates(list1Start)
    while (res != null) {
        print(res.`val`)
        res = res.next
    }
}