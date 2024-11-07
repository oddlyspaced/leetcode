package medium

class Problem2275 {
    fun largestCombination(candidates: IntArray): Int {
        var maxSize = 0
        val subset = mutableListOf<Int>()
        fun dfs(cur: Int) {
            if (cur >= candidates.size) {
                if (subset.isNotEmpty()) {
                    val res = subset.reduce { acc, i ->
                        acc and i
                    }
                    if (res > 0 && maxSize < subset.size) {
                        maxSize = subset.size
                    }
                }
                return
            }
            subset.add(candidates[cur])
            dfs(cur + 1)
            subset.removeLast()
            dfs(cur + 1)
        }
        dfs(0)
        return maxSize
    }
}

fun main() {
    println(Problem2275().largestCombination(intArrayOf(16, 17, 71, 62, 12, 24, 14)))
//    println(Problem2275().largestCombination(intArrayOf(1, 2, 3)))
}