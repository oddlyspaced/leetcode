package old.hard

import old.easy.TreeNode
import kotlin.math.max


// https://www.youtube.com/watch?v=EY4bCorJH4g
class Problem2458 {
    private fun findHeight(
        curr: TreeNode?,
        level: Int,
        nodeLevel: MutableMap<Int, Pair<Int, Int>>,
        top2Nodes: MutableMap<Int, Pair<Int, Int>>
    ): Int {
        if (curr == null) return 0

        val height = (1 + max(
            findHeight(curr.left, level + 1, nodeLevel, top2Nodes).toDouble(),
            findHeight(curr.right, level + 1, nodeLevel, top2Nodes).toDouble()
        )).toInt()

        nodeLevel[curr.`val`] = Pair(level, height)

        if (height > top2Nodes.getOrDefault(level, Pair(0, 0)).first) {
            top2Nodes[level] =
                Pair(height, top2Nodes.getOrDefault(level, Pair(0, 0)).first)
        } else if (height > top2Nodes[level]!!.second) {
            top2Nodes[level] = Pair(top2Nodes[level]!!.first, height)
        }

        return height
    }

    fun treeQueries(root: TreeNode?, queries: IntArray): List<Int> {
        val top2NodesLevel: MutableMap<Int, Pair<Int, Int>> = HashMap()
        val nodeLevel: MutableMap<Int, Pair<Int, Int>> = HashMap()

        findHeight(root, 0, nodeLevel, top2NodesLevel)

        val res: MutableList<Int> = ArrayList()
        for (queryNode in queries) {
            val level = nodeLevel[queryNode]!!.first
            val height = nodeLevel[queryNode]!!.second
            val maxH =
                if ((top2NodesLevel[level]!!.first == height)) top2NodesLevel[level]!!.second else top2NodesLevel[level]!!.first
            res.add(maxH + level - 1)
        }
        return res
    }
}


fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(3)
    root.right = TreeNode(4)
    root.left?.left = TreeNode(2)
    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(5)
    root.right?.right?.right = TreeNode(7)
    println(Problem2458().treeQueries(root, intArrayOf(4)).joinToString(","))
}