package old.easy

class Problem1408 {
    fun stringMatching(words: Array<String>): List<String> {
        val res = mutableSetOf<String>()
        for (i in words.indices) {
            for (j in words.indices) {
                if (i != j && words[i].contains(words[j])) {
                    res.add(words[j])
                }
            }
        }
        return res.toList()
    }
}

fun main() {
    println(Problem1408().stringMatching(arrayOf("mass","as","hero","superhero")))
}