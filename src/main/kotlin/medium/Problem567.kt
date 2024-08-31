package medium

class Problem567 {
    private fun match(s1: String, s2: String): Boolean {
        val map = hashMapOf<Char, Int>()
        for (i in s1.indices) {
            map[s1[i]] = (map[s1[i]] ?: 0) + 1
            map[s2[i]] = (map[s2[i]] ?: 0) - 1
        }
        for (key in map.keys) {
            if (map[key] != 0) {
                return false
            }
        }
        return true
    }

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) {
            return false
        }
        val sb = StringBuilder()

        var i = 0
        repeat(s1.length) {
            sb.append(s2[i++])
        }
        while (i < s2.length) {
            if (match(s1, sb.toString())) {
                return true
            }
            sb.deleteCharAt(0)
            sb.append(s2[i++])
        }
        return match(s1, sb.toString())
    }
}

fun main() {
    println(Problem567().checkInclusion("ab", "eidbaooo")) // true
    println(Problem567().checkInclusion("ab", "eidboaoo")) // false
    println(Problem567().checkInclusion("adc", "dcda")) // false
    println(Problem567().checkInclusion("hello", "ooolleoooleh")) // false
}