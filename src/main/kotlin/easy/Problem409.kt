package easy

class Problem409 {
    fun longestPalindrome(s: String): Int {
        val m = hashMapOf<Char, Int>()
        s.forEach {
            m[it] = (m[it] ?: 0) + 1
        }

        var largestOddChar = 'a'
        var largestOddValue = 0

        m.keys.forEach {
            m[it]?.let { v ->
                if (largestOddValue < v) {
                    largestOddValue = v
                    largestOddChar = it
                }
            }
        }

        m[largestOddChar] = m[largestOddChar]!! - 1
        var max = 0

        m.keys.forEach {
            m[it]?.let { v ->
                max += v
            }
        }

        return max
    }
}

fun main() {
    println(Problem409().longestPalindrome(
        "abccccdd"
    ))
}