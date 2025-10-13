package old.easy

class Problem242 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val sc = HashMap<Char, Int>()
        val tc = HashMap<Char, Int>()

        for (i in s.indices) {
            sc[s[i]] = (sc[s[i]] ?: 0) + 1
            tc[t[i]] = (tc[t[i]] ?: 0) + 1
        }

        if (sc.keys.size != tc.keys.size) {
            return false
        }

        sc.keys.forEach {
            if (sc[it] != tc[it]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    println(Problem242().isAnagram("anagram", "nagaram"))
    println(Problem242().isAnagram("rat", "car"))
}