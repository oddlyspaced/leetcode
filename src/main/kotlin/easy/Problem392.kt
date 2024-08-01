class Problem392 {
    fun isSubsequence(s: String, t: String): Boolean {
        var si = 0
        var ti = 0
        while (ti < t.length && si < s.length) {
            if (s[si] == t[ti]) {
                si++
            }
            ti++

        }
        return si == s.length
    }
}

fun main() {
    println(Problem392().isSubsequence("abc", "ahbgdc"))
    println(Problem392().isSubsequence("axc", "ahbgdc"))
}