package easy

class Problem160 {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        if (headA == headB) {
            return headA
        }
        var a = headA
        var b = headB

        var ac = 0
        var bc = 0

        while (a != null) {
            a = a.next
            ac++
        }

        while (b != null) {
            b = b.next
            bc++
        }

        if (ac < bc) {
            b = headA
            a = headB
        }
        else {
            a = headA
            b = headB
        }

        var copy = a

        while (b != null) {
            if (copy != null) {
                if (copy.next == b.next) {
                    return b.next
                }
                else {
                    copy = copy.next
                }
            }
            else {
                a = a?.next
                copy = a
                b = b.next
            }
        }
        return ListNode(0)
    }
}