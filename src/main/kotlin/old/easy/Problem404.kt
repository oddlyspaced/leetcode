package old.easy

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Problem404 {


    private var sum = 0
    private fun preorder(root: TreeNode?, isLeft: Boolean) {
        if (root?.left == null && root?.right == null && isLeft) {
            sum += root?.`val` ?: 0
        }
        if (root?.left != null) {
            preorder(root.left, true)
        }
        if (root?.right != null) {
            preorder(root.right, false)
        }
    }

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        preorder(root, false)
        return sum
    }
}

fun main() {
    val root = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    println(Problem404().sumOfLeftLeaves(root))
}