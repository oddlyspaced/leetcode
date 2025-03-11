package medium

class Problem1358 {
    fun numberOfSubstrings(s: String): Int {
        var res = 0
        val current = intArrayOf(0, 0, 0)
        var left = 0
        for (right in s.indices) {
            current[s[right] - 'a']++
            while (current.all { it > 0 }) {
                // all chars are present
                current[s[left] - 'a']--
                left++
            }
            res += left
        }
        return res
    }
}

fun main() {
    println(Problem1358().numberOfSubstrings("abcabc"))
}