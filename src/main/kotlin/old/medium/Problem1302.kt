package old.medium

import old.easy.TreeNode

class Problem1302 {

    private var sum = 0
    private var maxDepth = 0

    private fun preorder(node: TreeNode?, height: Int) {
        if (node?.left != null) {
            preorder(node.left, height + 1)
        }
        if (maxDepth < height) {
            maxDepth = height
        }
        if (node?.right != null) {
            preorder(node.right, height + 1)
        }
    }

    private fun preSum(node: TreeNode?, height: Int) {
        if (node?.left != null) {
            preSum(node.left, height + 1)
        }
        if (height == maxDepth && node != null) {
            sum += node.`val`
        }
        if (node?.right != null) {
            preSum(node.right, height + 1)
        }
    }

    fun deepestLeavesSum(root: TreeNode?): Int {
        preorder(root, 0)
        preSum(root, 0)
        return sum
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(4)
    root.left?.right = TreeNode(5)
    root.left?.left?.left = TreeNode(7)
    root.right = TreeNode(3)
    root.right?.right = TreeNode(6)
    root.right?.right?.right = TreeNode(8)

    println(Problem1302().deepestLeavesSum(root))
}