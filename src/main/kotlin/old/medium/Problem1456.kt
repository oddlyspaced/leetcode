package old.medium

import kotlin.math.max

class Problem1456 {
    fun maxVowels(s: String, k: Int): Int {
        var count = 0
        val vowels = "aeiou"
        for (i in 0..<k) {
            if (vowels.contains(s[i])) {
                count++
            }
        }
        var maxCount = count
        for (i in k..<s.length) {
            if (vowels.contains(s[i])) {
                count++
            }
            if (vowels.contains(s[i - k])) {
                count--
            }
            maxCount = max(count, maxCount)
        }
        return maxCount
    }
}

fun main() {
    println(Problem1456().maxVowels("abciiidef", 3))
    println(Problem1456().maxVowels("aeiou", 2))
    println(Problem1456().maxVowels("leetcode", 3))
    println(Problem1456().maxVowels("pdzndkhhoujpqyex", 5))
    println(Problem1456().maxVowels("tnfazcwrryitgacaabwm", 4))
}