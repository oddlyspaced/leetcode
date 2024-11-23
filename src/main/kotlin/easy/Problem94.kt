package easy

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Problem94 {
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

    val data = arrayListOf<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root?.left != null) {
            inorderTraversal(root.left)
        }
        println(root?.`val`)
        root?.`val`?.let { data.add(it) }
        if (root?.right != null) {
            inorderTraversal(root.right)
        }
        return data
    }
}