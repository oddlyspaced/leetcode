package medium

class Problem3306 {
    private fun isVowel(c: Char): Boolean {
        return c in listOf('a', 'e', 'i', 'o', 'u')
    }

    private fun atLeastK(word: String, k: Int): Long {
        val n = word.length
        var ans = 0L
        var consonants = 0
        var left = 0
        val vowelMap = HashMap<Char, Int>()

        for (right in 0 until n) {
            val c = word[right]
            if (isVowel(c)) {
                vowelMap[c] = vowelMap.getOrDefault(c, 0) + 1
            } else {
                consonants++
            }

            while (vowelMap.size == 5 && consonants >= k) {
                ans += n - right
                val leftChar = word[left]
                if (isVowel(leftChar)) {
                    vowelMap[leftChar] = vowelMap[leftChar]!! - 1
                    if (vowelMap[leftChar] == 0) {
                        vowelMap.remove(leftChar)
                    }
                } else {
                    consonants--
                }
                left++
            }
        }
        return ans
    }

    fun countOfSubstrings(word: String, k: Int): Long {
        return atLeastK(word, k) - atLeastK(word, k + 1)
    }
}

fun main() {
    println(Problem3306().countOfSubstrings("aeioqq", 1))
    println(Problem3306().countOfSubstrings("aeiou", 0))
    println(Problem3306().countOfSubstrings("ieaouqqieaouqq", 1))
    println(Problem3306().countOfSubstrings("iqeaouqi", 2))
}