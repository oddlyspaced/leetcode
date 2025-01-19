package easy

class Problem125 {
    fun isPalindrome(s: String): Boolean {
        var s = s.filter {
            it.isLetterOrDigit()
        }.lowercase()
        for (i in 0..(s.length - 1) / 2) {
            if (s[i] != s[s.length - 1 - i])
                return false
        }
        return true
    }
}

fun main() {
    println(Problem125().isPalindrome("A man, a plan, a canal: Panama"))
    println(Problem125().isPalindrome("race a car"))
}