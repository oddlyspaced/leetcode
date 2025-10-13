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
class Problem104 {

    var max = 1
    fun traverse(root: TreeNode?, depth: Int) {
        if (root?.left != null) {
            traverse(root.left, depth + 1)
        }
        if (root?.right != null) {
            traverse(root.right, depth + 1)
        }
//        println("DEPTH : ${depth}")
        if (depth > max) {
            max = depth
        }
    }

    fun maxDepth(root: TreeNode?): Int {
        traverse(root, 1)
        return max
    }
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    println(Problem104().maxDepth(root))
}