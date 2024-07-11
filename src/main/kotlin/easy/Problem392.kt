package easy

class Problem392 {
    fun isSubsequence(s: String, t: String): Boolean {
        var index = 0
        var match = 0
        while (index < t.length) {
            if (t[index] == s[match]) {
                match++
            }
            if (match == s.length) {
                return true
            }
            index++
        }
        return match == s.length
    }
}

fun main() {
    println(Problem392().isSubsequence("abc", "ahbgdc"))
    println(Problem392().isSubsequence("b", "abc"))
}