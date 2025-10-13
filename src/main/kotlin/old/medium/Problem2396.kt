package old.medium

class Problem2396 {
    private fun pal(s: String): Boolean {
        for (i in 0..(s.length / 2)) {
            if (s[i] != s[s.length - 1 - i]) {
                return false
            }
        }
        return true
    }

    fun isStrictlyPalindromic(n: Int): Boolean {
        for (i in 2..(n - 2)) {
            if (!pal(n.toString(i))) {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(Problem2396().isStrictlyPalindromic(9))
}