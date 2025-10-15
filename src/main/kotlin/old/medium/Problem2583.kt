package old.medium

import old.easy.TreeNode

class Problem2583 {

    private val levelSum = hashMapOf<Int, Long>()

    private fun dfs(root: TreeNode?, depth: Int) {
        if (root == null) {
            return
        }
        levelSum[depth] = (levelSum[depth] ?: 0) + root.`val`
        if (root.left != null) {
            dfs(root.left, depth + 1)
        }
        if (root.right != null) {
            dfs(root.right, depth + 1)
        }
    }

    fun kthLargestLevelSum(root: TreeNode?, k: Int): Long {
        dfs(root, 0)
        levelSum.keys.forEach {
            println("Level $it = ${levelSum[it]}")
        }
        return if (levelSum.values.size < k) {
            -1
        } else {
            levelSum.values.sortedDescending()[k - 1]
        }
    }
}

fun main() {
    val root = TreeNode(5)
    root.left = TreeNode(8)
    root.right = TreeNode(9)
    root.left?.left = TreeNode(2)
    root.left?.right = TreeNode(1)
    root.left?.left?.left = TreeNode(4)
    root.left?.left?.right = TreeNode(6)
    root.right?.left = TreeNode(3)
    root.right?.right = TreeNode(7)

    println(Problem2583().kthLargestLevelSum(root, 2))

    val root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.left?.left = TreeNode(3)
    println(Problem2583().kthLargestLevelSum(root2, 1))
}