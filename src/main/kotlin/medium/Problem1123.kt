package medium

import com.sun.source.tree.Tree
import easy.TreeNode

/**
 * Created by Hardik Srivastava on 04/04/25
 */
class Problem1123 {
    private var common: TreeNode? = null
    private var maxDepth = 0

    private fun dfs(node: TreeNode?, depth: Int): Int {
        if (node == null) return depth // tree ended

        val leftDepth = dfs(node.left, depth + 1)
        val rightDepth = dfs(node.right, depth + 1)
        val currentMaxDepth = maxOf(leftDepth, rightDepth)
        maxDepth = maxOf(maxDepth, currentMaxDepth)

        // both left right equal
        if (leftDepth == maxDepth && rightDepth == maxDepth) {
            common = node
        }
        return currentMaxDepth
    }

    fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
        dfs(root, 0)
        return common
    }
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(5)
    root.right = TreeNode(1)
    root.left?.left = TreeNode(6)
    root.left?.right = TreeNode(2)
    root.left?.right?.left = TreeNode(7)
    root.left?.right?.right = TreeNode(4)
    root.right?.left = TreeNode(0)
    root.right?.right = TreeNode(8)
    val res = Problem1123().lcaDeepestLeaves(root)
    println("${res?.`val`} -> ${res?.left?.`val`} , ${res?.right?.`val`}")
}