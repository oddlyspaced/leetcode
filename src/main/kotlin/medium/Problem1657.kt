package medium

class Problem1657 {
    fun closeStrings(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) {
            return false
        }
        val word1Map = hashMapOf<Char, Int>()
        val word2Map = hashMapOf<Char, Int>()
        word1.forEach {
            word1Map[it] = (word1Map[it] ?: 0) + 1
        }
        word2.forEach {
            word2Map[it] = (word2Map[it] ?: 0) + 1
        }
        // check if count of all characters is same
        if (word1Map.keys.size != word2Map.keys.size) {
            return false
        }
//        println("${word1Map.keys} ${word1Map.values}")
//        println("${word2Map.keys} ${word2Map.values}")
        word1Map.keys.forEach { key ->
            if (!word2Map.containsKey(key)) {
                return false
            }
        }
        // also values must be same for chars
        val map1Vals = word1Map.values.sorted()
        val map2Vals = word2Map.values.sorted()
        for (i in map1Vals.indices) {
            if (map1Vals[i] != map2Vals[i]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    println(Problem1657().closeStrings("abbzzca", "babzzcz"))
}