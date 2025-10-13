package old.easy

import kotlin.math.max

class Problem1422 {
    fun maxScore(s: String): Int {
        var z = 0
        var o = s.count { it == '1' }
        var res = 0

        for (i in 0..<s.length - 1) {
            if (s[i] == '0') {
                z++
            }
            else {
                o--
            }
            res = maxOf(res, z + o)
        }

        return res
    }
}

// 1111
/*
1 111
11 11
111 1


00
0 0

011101

0 11101
01 1101
011 101
0111 01
01110 1
 */

fun main() {
    println(Problem1422().maxScore("011101"))
    println(Problem1422().maxScore("1111"))
    println(Problem1422().maxScore("00"))
    println(Problem1422().maxScore("110000"))
}