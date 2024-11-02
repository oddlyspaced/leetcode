package easy

class Problem2490 {
    fun isCircularSentence(sentence: String): Boolean {
        val words = sentence.split(" ")
        for (i in words.indices) {
            val cur = words[i]
            val next = if (i == words.size - 1) words[0] else words[i + 1]
            if (cur.last() != next.first()) {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(Problem2490().isCircularSentence("leetcode exercises sound delightful"))
    println(Problem2490().isCircularSentence("eetcode"))
    println(Problem2490().isCircularSentence("Leetcode is cool"))
}