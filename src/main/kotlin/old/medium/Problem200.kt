package old.medium

class Problem200 {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }

        val rows = grid.size
        val cols = grid[0].size

        // stores visited r,c
        val visited = hashSetOf<Pair<Int, Int>>()
        var islands = 0

        fun bfs(r: Int, c: Int) {
            val q = ArrayDeque<Pair<Int, Int>>()
            visited.add(Pair(r, c))
            q.add(Pair(r, c))
            while (q.isNotEmpty()) {
                val t = q.removeLast()
                val row = t.first
                val col = t.second
                val dirs = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

                for (dir in dirs) {
                    val r = row + dir.first
                    val c = col + dir.second
                    if ((0..<rows).contains(r) && (0..<cols).contains(c) && grid[r][c] == '1' && !visited.contains(Pair(r, c))) {
                        q.add(Pair(r, c))
                        visited.add(Pair(r, c))
                    }
                }

            }
        }

        for (r in 0..<rows) {
            for (c in 0..<cols) {
                if (grid[r][c] == '1' && !visited.contains(Pair(r, c))) {
                    bfs(r, c)
                    islands++
                }
            }
        }
        return islands
    }
}

fun main() {
    println(
        Problem200().numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        )
    )
}