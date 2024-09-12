package easy

class Problem1684 {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val allowedChars = hashSetOf<Char>()
        allowed.forEach {
            allowedChars.add(it)
        }
        var res = 0
        for (word in words) {
            var valid = true
            for (c in word) {
                if (!allowedChars.contains(c)) {
                    valid = false
                    break
                }
            }
            if (valid) {
                res++
            }
        }
        return res
    }
}

fun main() {
    println(Problem1684().countConsistentStrings("ab", arrayOf("ad", "bd", "aaab", "baa", "badab")))
}