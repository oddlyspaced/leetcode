package old.medium

import easy.TreeNode

class Problem2641 {

    private val sum = hashMapOf<Int, Int>()

    private fun sumAll(root: TreeNode?, level: Int) {
        if (root == null) {
            return
        }
        sum[level] = (sum[level] ?: 0) + root.`val`
        if (root.left != null) {
            sumAll(root.left, level + 1)
        }
        if (root.right != null) {
            sumAll(root.right, level + 1)
        }
    }

    private fun update(root: TreeNode?, level: Int) {
        if (root == null) {
            return
        }
        var childSum = 0
        if (root.left != null) {
            childSum += root.left!!.`val`
        }
        if (root.right != null) {
            childSum += root.right!!.`val`
        }
        if (root.left != null) {
            root.left!!.`val` = (sum[level + 1] ?: 0) - childSum
        }
        if (root.right != null) {
            root.right!!.`val` = (sum[level + 1] ?: 0) - childSum
        }
        if (root.left != null) {
            update(root.left, level + 1)
        }
        if (root.right != null) {
            update(root.right, level + 1)
        }
    }

    fun replaceValueInTree(root: TreeNode?): TreeNode? {
        sumAll(root, 0)
        update(root, 0)
        root?.`val` = 0
        return root
    }
}

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(9)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(10)
    root.right?.right = TreeNode(7)
    val res = Problem2641().replaceValueInTree(root)
    println(res?.`val`)
    println(res?.left?.`val`)
    println(res?.right?.`val`)
    println(res?.left?.left?.`val`)
    println(res?.right?.right?.`val`)
}