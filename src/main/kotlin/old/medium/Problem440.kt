package old.medium

import java.util.*

class Problem440 {

    val result = ArrayList<Int>()

    private fun dfs(number: Int, n: Int) {
        if (number > n) return
        result.add(number)
        for (i in 0..9) {
            dfs(number * 10 + i, n)
        }
    }

    fun findKthNumber(n: Int, k: Int): Int {
        for (i in 1..9) {
            dfs(i, n)
        }
        return result[k]
    }
}