package old.hard

// https://leetcode.com/problems/minimum-total-distance-traveled/solutions/5988442/let-s-understand-it-with-clear-visualization-for-dp-and-recursion-with-added-youtube-video
// ^ Reference Solution
class Problem2463 {
    // Dynamic Approach
    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
        val sortedRobot = robot.sorted()
        factory.sortBy { it[0] }

        val factoryPos = arrayListOf<Int>()
        for (d in factory) {
            repeat(d[1]) {
                factoryPos.add(d[0])
            }
        }

        val m = sortedRobot.size
        val n = factoryPos.size
        val dp = Array(m + 1) { LongArray(n + 1) { 0L } }

        for (i in 0 until m) {
            dp[i][n] = 1e12.toLong()
        }

        for (i in m - 1 downTo 0) {
            for (j in n - 1 downTo 0) {
                val pick = Math.abs(sortedRobot[i] - factoryPos[j]) + dp[i + 1][j + 1]
                val notPick = dp[i][j + 1]
                dp[i][j] = minOf(pick, notPick)
            }
        }

        return dp[0][0]
    }

    // Recursion with memoization
    fun memo(
        robIndex: Int,
        facIndex: Int,
        robot: List<Int>,
        factoryPos: ArrayList<Int>,
        dp: Array<LongArray>
    ): Long {
        if (robIndex >= robot.size) return 0L
        if (facIndex >= factoryPos.size) return 1e12.toLong()

        if (dp[robIndex][facIndex] != -1L) return dp[robIndex][facIndex]

        val pick = Math.abs(robot[robIndex] - factoryPos[facIndex]) +
                memo(robIndex + 1, facIndex + 1, robot, factoryPos, dp)

        val notPick = memo(robIndex, facIndex + 1, robot, factoryPos, dp)
        dp[robIndex][facIndex] = minOf(pick, notPick)

        return dp[robIndex][facIndex]
    }
}