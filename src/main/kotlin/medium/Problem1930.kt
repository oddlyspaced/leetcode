package medium

class Problem1930 {
    fun countPalindromicSubsequence(s: String): Int {
        val left = hashSetOf<Char>()
        val right = hashMapOf<Char, Int>()
        s.forEach {
            right[it] = right.getOrDefault(it, 0) + 1
        }
        val res = hashSetOf<String>()
        for (i in s.indices) {
            val t = s[i] // m char
            if (right.getOrDefault(t, 0) > 0) {
                right[t] = right[t]!! - 1
            }
            else {
                continue
            }
            // find common between left and right
            left.forEach {
                if (right.getOrDefault(it, 0) > 0) {
                    res.add("${it}${t}")
                }
            }
            left.add(t)
        }
        return res.size
    }
}

fun main() {
    println(Problem1930().countPalindromicSubsequence("aabca"))
    println(Problem1930().countPalindromicSubsequence("adc"))
    println(Problem1930().countPalindromicSubsequence("bbcbaba"))
}