package easy

class Problem459 {
    fun repeatedSubstringPattern(s: String): Boolean {
        var sublen = s.length / 2
        while (sublen > 0) {
            if (s.length % sublen > 0) {
                sublen--
            }
            else {
                var i = sublen + 1
                while (i < s.length) {
                    if (s[i % sublen] != s[i]) {
                        break
                    }
                    i++
                }
                if (i == s.length) {
                    return true
                }
                sublen--
            }
        }
        return false
    }
}

fun main() {
    println(Problem459().repeatedSubstringPattern("abcabcabcabc"))
    println(Problem459().repeatedSubstringPattern("aba"))
    println(Problem459().repeatedSubstringPattern("abab"))
    println("---")
    println(Problem459().repeatedSubstringPattern("abaababaab"))
    println(Problem459().repeatedSubstringPattern("aabaaba"))
}