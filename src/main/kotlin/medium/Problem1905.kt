package medium

class Problem1905 {
    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        val rows = grid1.size
        val cols = grid1[0].size

        val visited = hashSetOf<Pair<Int, Int>>()
        var result = 0

        fun dfs(r: Int, c: Int): Boolean {
            if (r < 0 || c < 0 || r == rows || c == cols || grid2[r][c] == 0 || visited.contains(Pair(r, c))) {
                return true
            }
            visited.add(Pair(r, c))
            var res = true
            if (grid1[r][c] == 0) {
                res = false
            }
            res = res && dfs(r - 1, c)
            res = res && dfs(r + 1, c)
            res = res && dfs(r, c - 1)
            res = res && dfs(r, c + 1)
            return res
        }


        for (r in 0..<rows) {
            for (c in 0..<cols) {
                if (grid2[r][c] == 1 && !visited.contains(Pair(r, c)) && dfs(r, c)) {
                    result++
                }
            }
        }
        return result
    }
}