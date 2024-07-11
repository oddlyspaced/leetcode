package easy

class Problem101 {
    private val left = arrayListOf<Int?>()
    private val right = arrayListOf<Int?>()

    private fun traverseLeft(root: TreeNode?) {
        if (root?.left != null) {
            traverseLeft(root.left)
        }
        left.add(root?.`val`)
        if (root?.right != null) {
            traverseLeft(root.right)
        }
    }

    private fun traverseRight(root: TreeNode?) {
        if (root?.right != null) {
            traverseRight(root.right)
        }
        right.add(root?.`val`)
        if (root?.left != null) {
            traverseRight(root.left)
        }
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        traverseLeft(root?.left)
        traverseRight(root?.right)
        return left == right
    }
}

fun main() {
    val root = TreeNode(2)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)

    root.right = TreeNode(2)
    root.right?.left = TreeNode(4)
    root.right?.right = TreeNode(3)
}