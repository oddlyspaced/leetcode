package hard

import kotlin.math.min

class Problem664 {

    lateinit var memo: Array<Array<Int>>

    private fun solve(l: Int, r: Int, s: String): Int {
        if (l == r) {
            return 1
        }
        if (l > r) {
            return 0
        }
        if (memo[l][r] != -1) {
            return memo[l][r]
        }
        var i = l + 1
        while (i <= r && s[i] == s[l])
            i++
        if (i == r + 1) {
            return 1
        }

        val basic = 1 + solve(i, r, s)
        var second = Int.MAX_VALUE
        for (j in i..r) {
            if (s[j] == s[l]) {
                val ans = solve(i, j - 1, s) + solve(j, r, s)
                second = min(second, ans)
            }
        }
        memo[l][r] = min(basic, second)
        return memo[l][r]
    }

    fun strangePrinter(s: String): Int {
        memo = Array(s.length + 1) {
            Array(s.length + 1) {
                -1
            }
        }
        return solve(0, s.length - 1, s)
    }
}

fun main() {
    Problem664().strangePrinter("aaabbb")
    Problem664().strangePrinter("aba")
}

// a a a a a a
//   b
//     c
//       b
//         c