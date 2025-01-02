package medium

class Problem2559 {
    private fun valid(word: String): Boolean {
        val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')
        return vowels.contains(word.first()) && vowels.contains(word.last())

    }

    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val countArr = IntArray(words.size)
        var count = 0
        words.forEachIndexed { index, s ->
            if (valid(s)) {
                count++
            }
            countArr[index] = count
        }
        val res = IntArray(queries.size)
        queries.forEachIndexed { index, ints ->
            res[index] = countArr[ints.last()]
            if (ints.first() > 0) {
                res[index] -= countArr[ints.first() - 1]
            }
        }
        return res
    }
}

fun main() {
    println(
        Problem2559().vowelStrings(
            arrayOf("aba", "bcb", "ece", "aa", "e"), arrayOf(
                intArrayOf(0, 2), intArrayOf(1, 4), intArrayOf(1, 1)
            )
        ).joinToString(",")
    )
    println(
        Problem2559().vowelStrings(
            arrayOf("a", "e", "i"), arrayOf(
                intArrayOf(0, 2), intArrayOf(0, 1), intArrayOf(2, 2)
            )
        ).joinToString(",")
    )
}