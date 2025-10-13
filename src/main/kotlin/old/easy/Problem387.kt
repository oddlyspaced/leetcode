package old.easy

class Problem387 {
    fun firstUniqChar(s: String): Int {
        val chars = linkedSetOf<Char>()
        val index = hashMapOf<Char, Int>()
        val count = hashMapOf<Char, Int>()
        s.forEachIndexed { i, v ->
            chars.add(v)
            if (index[v] == null) {
                index[v] = i
            }
            count[v] = (count[v] ?: 0) + 1
        }
        chars.forEach {
            if (count[it] == 1) {
                return index[it]!!
            }
        }
        return -1
    }
}

fun main() {
    println(Problem387().firstUniqChar("loveleetcode"))
}