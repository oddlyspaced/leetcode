package easy

class Problem345 {
    fun reverseVowels(s: String): String {
        val sb = StringBuilder(s)
        var l = 0
        var r = s.length - 1
        val vowels = charArrayOf('a', 'e', 'i', 'o', 'u')
        while (l < r) {
            if (!vowels.contains(sb[l])) {
                l++
            } else if (!vowels.contains(sb[r])) {
                r--
            } else {
                val t = sb[l]
                sb[l] = sb[r]
                sb[r] = t
                l++
                r--
            }
        }
        return sb.toString()
    }
}

fun main() {
    println(Problem345().reverseVowels("hello"))
    println(Problem345().reverseVowels("leetcode"))
}