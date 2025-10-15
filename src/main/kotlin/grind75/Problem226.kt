package grind75

/**
 * Created by Hardik Srivastava on 15/10/25
 */
class Problem226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val t = root.left
        root.left = root.right
        root.right = t

        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}