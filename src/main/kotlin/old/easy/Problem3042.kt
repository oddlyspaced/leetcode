package old.easy

class Problem3042 {
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        var res = 0
        for (i in words.indices) {
            for (j in (i + 1)..<words.size) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    res++
                }
            }
        }
        return res
    }
}

fun main() {
    println(Problem3042().countPrefixSuffixPairs(arrayOf("a", "aba", "ababa", "aa")))
}