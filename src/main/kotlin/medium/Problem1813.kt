package medium

import java.lang.Exception

class Problem1813 {
    fun areSentencesSimilar(sentence1: String, sentence2: String): Boolean {
        val smaller = if (sentence1.length < sentence2.length) sentence1 else sentence2
        val larger = if (sentence1.length < sentence2.length) sentence2 else sentence1

        val smallerWords = smaller.split(" ").toMutableList()
        val largerWords = larger.split(" ").toMutableList()

        while (smallerWords.isNotEmpty() && smallerWords.last() == largerWords.last()) {
            smallerWords.removeLast()
            largerWords.removeLast()
        }

        while (smallerWords.isNotEmpty() && smallerWords.first() == largerWords.first()) {
            smallerWords.removeFirst()
            largerWords.removeFirst()
        }

        return smallerWords.isEmpty()
    }
}

fun main() {
    println(Problem1813().areSentencesSimilar("My name is Haley", "My Haley"))
    println(Problem1813().areSentencesSimilar("of", "A lot of words"))
    println(Problem1813().areSentencesSimilar("Eating right now", "Eating"))
    println(Problem1813().areSentencesSimilar("hsYZKp Cn eE", "hsYZKp eE"))
    println(
        Problem1813().areSentencesSimilar(
            "jiRNY fW rN S bpL r T S nl vndZkF om oUm ilsf pvyNJObW F Uj QNJUek",
            "jiRNY fW rN S bpL r T Uj QNJUek"
        )
    )
    println(Problem1813().areSentencesSimilar("A", "a A b A"))
}