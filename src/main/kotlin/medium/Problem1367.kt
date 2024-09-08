package medium

import easy.ListNode
import easy.TreeNode

class Problem1367 {

    private fun check(listNode: ListNode?, treeNode: TreeNode?): Boolean {
        if (listNode == null) {
            return true
        }
        if (treeNode == null || listNode.`val` != treeNode.`val`) {
            return false
        }
        return check(listNode.next, treeNode.left) || check(listNode.next, treeNode.right)
    }

    fun isSubPath(head: ListNode?, root: TreeNode?): Boolean {
        if (check(head, root)) {
            return true
        }
        if (root == null) {
            return false
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right)
    }
}

fun main() {
//    val listHead = ListNode(4)
//    var listHeadCopy: ListNode? = listHead
//    intArrayOf(2, 8).forEach {
//        listHeadCopy?.next = ListNode(it)
//        listHeadCopy = listHeadCopy?.next
//    }
//
//    val root = TreeNode(1)
//
//    root.left = TreeNode(4)
//    root.left?.right = TreeNode(2)
//    root.left?.right?.left = TreeNode(1)
//
//    root.right = TreeNode(4)
//    root.right?.left = TreeNode(2)
//    root.right?.left?.left = TreeNode(6)
//    root.right?.left?.right = TreeNode(8)
//    root.right?.left?.right?.left = TreeNode(1)
//    root.right?.left?.right?.right = TreeNode(3)
    val listHead = ListNode(1)
    var listHeadCopy: ListNode? = listHead
    intArrayOf(4, 2, 6).forEach {
        listHeadCopy?.next = ListNode(it)
        listHeadCopy = listHeadCopy?.next
    }

    val root = TreeNode(1)
    root.left = TreeNode(4)
    root.left?.right = TreeNode(2)
    root.left?.right?.left = TreeNode(1)
    root.right = TreeNode(4)
    root.right?.left = TreeNode(2)
    root.right?.left?.left = TreeNode(6)
    root.right?.left?.right = TreeNode(8)
    root.right?.left?.right?.left = TreeNode(1)
    root.right?.left?.right?.right = TreeNode(3)

    println(Problem1367().isSubPath(listHead, root))
}