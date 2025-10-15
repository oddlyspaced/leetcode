package grind75

/**
 * Created by Hardik Srivastava on 15/10/25
 */
class Problem125 {
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (!s[l].isLetterOrDigit()) {
                l++
                continue
            }
            if (!s[r].isLetterOrDigit()) {
                r--
                continue
            }
            if (s[l].lowercase() != s[r].lowercase()) {
                return false
            }
            l++
            r--
        }
        return true
    }
}

fun main() {
    println(Problem125().isPalindrome("A man, a plan, a canal: Panama"))
}