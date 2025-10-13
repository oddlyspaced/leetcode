package old.easy

class Problem205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val sm = hashMapOf<Char, Char>()
        val tm = hashMapOf<Char, Char>()

        for (i in s.indices) {
            if (sm[s[i]] == null && tm[t[i]] == null) {
                sm[s[i]] = t[i]
                tm[t[i]] = s[i]
            }
            else if (sm[s[i]] == t[i] && tm[t[i]] == s[i]) {
                // do nothing
            }
            else {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(Problem205().isIsomorphic("paper", "title"))
    println(Problem205().isIsomorphic("badc", "baba"))
}