package old.medium

import old.easy.TreeNode


class Problem951 {
    fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
        if (root1 == null || root2 == null) {
            return (root1 == null && root2 == null)
        }
        if (root1.`val` != root2.`val`) {
            return false
        }
        val a = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
        return a || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
    }
}

fun main() {
    val root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    val root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.left?.left = TreeNode(3)
    println(Problem951().flipEquiv(root1, root2))
}