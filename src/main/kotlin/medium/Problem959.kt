package medium

class Problem959 {
    fun regionsBySlashes(grid: Array<String>): Int {
        // didn't understand shit.
        // copy pasted from neetcode
        val size = grid.size
        val nSize = size * 3

        val grid2 = arrayListOf<IntArray>()
        repeat(size) { i ->
            grid2.add(IntArray(nSize))
            repeat(size) { j ->
                val x = i * 3
                val y = j * 3
                if (grid[i][j] == '/') {
                    grid2[x][y] = 1
                    grid2[x + 1][y + 1] = 1
                    grid2[x + 2][y] = 1
                } else if (grid[i][j] == '\\') {
                    grid2[x][y] = 1
                    grid2[x + 1][y + 1] = 1
                    grid2[x + 2][y + 2] = 1
                }
            }
        }
        return 0
    }
}

fun main() {
    println(Problem959().regionsBySlashes(arrayOf("/\\", "\\/")))
}