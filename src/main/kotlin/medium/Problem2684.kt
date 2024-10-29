package medium

class Problem2684 {
    fun maxMoves(grid: Array<IntArray>): Int {
        val dp = hashMapOf<Pair<Int, Int>, Int>()

        fun dfs(r: Int, c: Int, prev: Int, moves: Int): Int {
            if (r >= grid.size || c >= grid[0].size || r < 0 || c < 0) {
                return moves
            }
            if (grid[r][c] <= prev) {
                return moves
            }
            if (dp[Pair(r, c)] != null) {
                return dp[Pair(r, c)]!!
            }
            dp[Pair(r, c)] = maxOf(
                dfs(r - 1, c + 1, grid[r][c], moves + 1),
                dfs(r, c + 1, grid[r][c], moves + 1),
                dfs(r + 1, c + 1, grid[r][c], moves + 1)
            )
            return dp[Pair(r, c)]!!
        }

        var res = -1
        for (i in grid.indices) {
            res = maxOf(res, dfs(i, 0, 0, -1))
        }
        return res
    }
}

fun main() {
    println(
        Problem2684().maxMoves(
            arrayOf(
                intArrayOf(2, 4, 3, 5), intArrayOf(5, 4, 9, 3),
                intArrayOf(3, 4, 2, 11), intArrayOf(10, 9, 13, 15),
            )
        )
    )
}