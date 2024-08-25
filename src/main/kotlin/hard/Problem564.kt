package hard

class Problem564 {

    private fun checkPalindrome(s: String): Boolean {
        return s == s.reversed()
    }

    fun nearestPalindromic(n: String): String {
        var num = n.toInt()
        if (num < 10) {
            return (num - 1).toString()
        }
        if (num in 11..99) {
            val check = arrayOf(11, 22, 33, 44, 55, 66, 77, 88, 99)
            if (num == 11) {
                return "9"
            } else if (check.contains(num)) {
                return ("${n[0].digitToInt() - 1}${n[0].digitToInt() - 1}")
            } else {
                return ("${n[0]}${n[0]}")
            }
        } else {
            if (checkPalindrome(n)) {
                return "11"
            } else {
                val sb = StringBuilder(n)
                for (i in 0..(sb.length / 2)) {
                    sb[sb.length - 1 - i] = sb[i]
                }
                return sb.toString()
            }
        }
    }
}

fun main() {
    println(Problem564().nearestPalindromic("1"))
    println(Problem564().nearestPalindromic("11"))
    println(Problem564().nearestPalindromic("12"))
    println(Problem564().nearestPalindromic("67"))
    println(Problem564().nearestPalindromic("44"))
    println(Problem564().nearestPalindromic("123"))
    println(Problem564().nearestPalindromic("222"))
    println(Problem564().nearestPalindromic("523"))

    println(Problem564().nearestPalindromic("1213"))

}