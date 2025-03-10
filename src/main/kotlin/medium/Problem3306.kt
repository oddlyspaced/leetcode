package medium

class Problem3306 {
    private fun isVowel(c: Char): Boolean {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
    }

    fun countOfSubstrings(word: String, k: Int): Long {
        var res = 0L
        var kCount = 0
        var windowStart = 0
        var vowels = hashMapOf<Char, Int>()

    }
}

fun main() {
    println(Problem3306().countOfSubstrings("aeioqq", 1))
    println(Problem3306().countOfSubstrings("aeiou", 0))
    println(Problem3306().countOfSubstrings("ieaouqqieaouqq", 1))
    println(Problem3306().countOfSubstrings("iqeaouqi", 2))
}