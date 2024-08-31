package medium


class Problem947 {

    private lateinit var stones: Array<IntArray>
    private lateinit var visited: BooleanArray

    private fun dfs(index: Int) {
        visited[index] = true

        for (i in stones.indices) {
            val r = stones[index][0]
            val c = stones[index][1];
            if (!visited[i] && (stones[i][0] == r && stones[i][1] == c)) {
                dfs(i)
            }
        }
    }

    fun removeStones(stns: Array<IntArray>): Int {
        stones = stns
        val n = stones.size
        visited = BooleanArray(n)

        var groups = 0
        for (i in 0..<n) {
            if (visited[i]) {
                continue
            }
            dfs(i);
            groups++
        }
        return n - groups
    }
}

fun main() {
    println(
        Problem947().removeStones(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 1),
                intArrayOf(1, 0),
                intArrayOf(1, 2),
                intArrayOf(2, 1),
                intArrayOf(2, 2)
            )
        )
    )
}