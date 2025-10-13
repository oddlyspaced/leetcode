package old.medium

import java.util.PriorityQueue

class Problem1514 {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start_node: Int, end_node: Int): Double {
        val adj = hashMapOf<Int, ArrayList<Pair<Int, Double>>>()
        for (i in edges.indices) {
            val src = edges[i][0]
            val dst = edges[i][1]
            if (adj[src] == null) {
                adj[src] = arrayListOf()
            }
            if (adj[dst] == null) {
                adj[dst] = arrayListOf()
            }
            adj[src]?.add(Pair(dst, succProb[i]))
            adj[dst]?.add(Pair(src, succProb[i]))
        }

        val pq = PriorityQueue<Pair<Int, Double>> { a, b ->
            if (a.second < b.second) 1 else -1
        }
        val visited = hashSetOf<Int>()

        adj[start_node]?.forEach {
            pq.add(it)
        }
        while (pq.isNotEmpty()) {
            val max = pq.poll()
            if (max.first == end_node) return max.second
            visited.add(max.first)
            adj[max.first]?.forEach {
                if (visited.contains(it.first).not()) {
                    pq.add(Pair(it.first, it.second * max.second))
                }
            }
        }
        return 0.0
    }
}

fun main() {
    println(
        Problem1514().maxProbability(
            3, arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(0, 2),
            ), doubleArrayOf(0.5, 0.5, 0.2), 2, 2
        )
    )
}