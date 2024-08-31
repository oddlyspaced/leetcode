package hard

import java.util.*
import kotlin.collections.ArrayList

class Problem2688 {
    fun modifiedGraphEdges(
        n: Int,
        edges: Array<IntArray>,
        source: Int,
        destination: Int,
        target: Int
    ): Array<IntArray> {
        val adj = Array(n) { IntArray(n) }
        for (i in edges) {
            val a = i[0]
            val b = i[1]
            val w = i[2]
            adj[a][b] = w
            adj[b][a] = w
        }
        var shortestPath = findPath(adj, source, destination, target)

        if (shortestPath == null) {
            return arrayOf()
        } else if (shortestPath.w == target) {
            return fill(adj)
        } else {
            while (true) {
                val curr = findFirstModifieableIndex(shortestPath!!.parent, destination, source, adj)
                    ?: return arrayOf()
                adj[curr[0]][curr[1]] = target - shortestPath.w + 1
                adj[curr[1]][curr[0]] = target - shortestPath.w + 1
                shortestPath = findPath(adj, source, destination, target)
                if (shortestPath!!.w == target) {
                    return fill(adj)
                } else if (shortestPath.w > target) {
                    return arrayOf()
                }
            }
        }
    }

    private fun findFirstModifieableIndex(parent: IntArray, dest: Int, source: Int, adj: Array<IntArray>): IntArray? {
        val list: MutableList<Int> = ArrayList()
        var curr = dest
        while (curr != -1) {
            list.add(curr)
            curr = parent[curr]
        }
        list.reverse()
        for (i in 0 until list.size - 1) {
            val v = list[i]
            val v2 = list[i + 1]
            if (adj[v][v2] == -1) {
                return intArrayOf(v, v2)
            }
        }
        return null
    }


    private fun fill(adj: Array<IntArray>): Array<IntArray> {
        val n = adj.size
        val list: MutableList<IntArray> = ArrayList()
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (adj[i][j] != 0) {
                    var c = adj[i][j]
                    if (c == -1) {
                        c = 1
                    }
                    list.add(intArrayOf(i, j, c))
                }
            }
        }
        val res = Array(list.size) { IntArray(3) }
        for (i in list.indices) {
            res[i] = list[i]
        }
        return res
    }

    private fun findPath(adj: Array<IntArray>, source: Int, destination: Int, target: Int): Pair? {
        val n = adj.size
        val dist = IntArray(n)
        val parent = IntArray(n)
        for (i in dist.indices) {
            dist[i] = Int.MAX_VALUE
        }
        for (i in parent.indices) {
            parent[i] = -1
        }
        dist[source] = 0
        parent[source] = -1
        val pq = PriorityQueue { a: IntArray, b: IntArray ->
            a[1] - b[1]
        }
        pq.offer(intArrayOf(source, dist[source]))
        while (!pq.isEmpty()) {
            val curr = pq.poll()
            val c = curr[0]
            val w = curr[1]
            if (w > target) {
                return null
            }
            if (c == destination) {
                return Pair(w, parent)
            }
            for (i in 0 until n) {
                if (adj[c][i] != 0) {
                    var nw = adj[c][i]
                    if (nw == -1) {
                        nw = 1
                    }
                    if (nw + w < dist[i]) {
                        dist[i] = nw + w
                        parent[i] = c
                        pq.offer(intArrayOf(i, dist[i]))
                    }
                }
            }
        }
        return null
    }

    class Pair(var w: Int, var parent: IntArray)
}