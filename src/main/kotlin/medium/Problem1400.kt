package medium

class Problem1400 {
    fun canConstruct(s: String, k: Int): Boolean {
        if (k > s.length) {
            return false
        }
        val charCounts = hashMapOf<Char, Int>()
        s.forEach {
            charCounts[it] = charCounts.getOrDefault(it, 0) + 1
        }
        var odd = 0
        charCounts.forEach { (c, count) ->
            if (count % 2 == 1) {
                odd++
            }
        }
        return odd <= k
    }
}

fun main() {
    println(Problem1400().canConstruct("annabelle", 2))
}