package old.medium

import kotlin.math.max

class Problem1593 {
    fun maxUniqueSplit(s: String): Int {
        fun dfs(i: Int, set: MutableSet<String>): Int {
            if (i == s.length) {
                return 0
            }
            var res = 0
            for (j in i..<s.length) {
                val sub = s.substring(i, j + 1)
                if (!set.contains(sub)) {
                    set.add(sub)
                    res = max(res, 1 + dfs(j + 1, set))
                }
            }
            return res
        }
        return dfs(0, mutableSetOf())
    }
}

fun main() {
    println(Problem1593().maxUniqueSplit("ababccc"))
}