package easy

import kotlin.math.max

class Problem1786 {
    fun mergeAlternately(word1: String, word2: String): String {
        var i = 0
        val sb = StringBuilder()
        while (i < max(word1.length, word2.length)) {
            if (i < word1.length) {
                sb.append(word1[i])
            }
            if (i < word2.length) {
                sb.append(word2[i])
            }
            i++
        }
        return sb.toString()
    }
}

fun main() {
    println(Problem1786().mergeAlternately("abcd", "pq"))
}