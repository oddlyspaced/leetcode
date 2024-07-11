package easy

class Problem242 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val mapS = hashMapOf<Char, Int>()
        val mapT = hashMapOf<Char, Int>()
        for (index in s.indices) {
            mapS[s[index]] = (mapS[s[index]] ?: 0) + 1
            mapT[t[index]] = (mapT[t[index]] ?: 0) + 1
        }
        mapS.keys.forEach {
            if (mapT[it] == null) {
                return false
            }
            if (mapT[it] != mapS[it]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(Problem242().isAnagram(s = "anagram", t = "nagaram"))
    println(Problem242().isAnagram(s = "rat", t = "car"))
    println(Problem242().isAnagram(s = "aa", t = "bb"))
}