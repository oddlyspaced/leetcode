package medium

class Problem916 {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val chars = IntArray(26)
        val res = arrayListOf<String>()
        for (i in words2.indices) {
            val freq = IntArray(26)
            words2[i].forEach {
                freq[it - 'a']++
                chars[it - 'a'] = maxOf(chars[it - 'a'], freq[it - 'a'])
            }
        }
        words1.forEach { word ->
            val temp = chars.copyOf()
            word.forEach { c ->
                if (temp[c - 'a'] > 0) {
                    temp[c - 'a']--
                }
            }
            val allZeroes = temp.count { it > 0 } == 0
            if (allZeroes) {
                res.add(word)
            }
        }
        return res
    }
}

fun main() {
    println(
        Problem916().wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("e", "o"))
            .joinToString(",")
    )
//    println(
//        Problem916().wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("l", "e"))
//            .joinToString(",")
//    )
}