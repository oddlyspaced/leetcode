package easy

class Problem876 {
    fun middleNode(head: ListNode?): ListNode? {
        var copy = head
        var i = 1
        while (copy != null) {
            var c = i
            var temp = copy
            while (c > 0 && temp != null) {
                temp = temp.next
                c--
            }
            if (temp == null) {
                return copy
            }
            else {
                copy = copy.next
                i++
            }
        }
        return null
    }
}

fun main() {
    val root = ListNode(1)
    root.next = ListNode(2)
    root.next!!.next = ListNode(3)
    root.next!!.next!!.next = ListNode(4)
    root.next!!.next!!.next!!.next = ListNode(5)
//    root.next!!.next!!.next!!.next!!.next = ListNode(6)
    println(Problem876().middleNode(root)?.`val`)
}