package old.medium

class Problem5 {

    private fun checkPalindrome(s: String): Boolean {
        for (i in 0..s.length / 2) {
            if (s[i] != s[s.length - 1 - i]) {
                return false
            }
        }
        return true
    }

    private fun checkPal(s: String, start: Int, len: Int): Boolean {
        return checkPalindrome(s.substring(start, start + len))
    }

    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) {
            return ""
        } else if (s.length == 1) {
            return s
        }
        else if (checkPalindrome(s)) {
            return s
        }

        val n = s.length - 1
        for (i in n downTo 1) {
            var j = 0
            while (j + i <= s.length) {
                val subRes = checkPal(s, j, i)
                if (subRes) {
                    return s.substring(j, j + i)
                }
                j++
            }
        }

        return ""
    }
}

fun main() {
    println(Problem5().longestPalindrome("babad"))
}