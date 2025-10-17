package grind75

/**
 * Created by Hardik Srivastava on 15/10/25
 */
class Problem235 {
    private fun checkNodeExists(root: TreeNode?, n: TreeNode?): Boolean {
        if (root?.`val` == n?.`val`) {
            return true
        }
        if (root?.left != null) {
            return checkNodeExists(root.left, n)
        }
        if (root?.right != null) {
            return checkNodeExists(root.right, n)
        }
        return false
    }

    private fun checkTree(root: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
        return (checkNodeExists(root, p) && checkNodeExists(root, q))
    }


    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

    }
}