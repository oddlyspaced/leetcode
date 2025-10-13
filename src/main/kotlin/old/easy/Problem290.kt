package old.easy

class Problem290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")
        if (pattern.length != words.size) {
            return false
        }
        val mapWP = hashMapOf<String, Char>()
        val mapPW = hashMapOf<Char, String>()
        for (index in words.indices) {
            if (mapWP[words[index]] == null && mapPW[pattern[index]] == null) {
                mapWP[words[index]] = pattern[index]
                mapPW[pattern[index]] = words[index]
            } else if (mapWP[words[index]] != pattern[index] || mapPW[pattern[index]] != words[index]) {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(Problem290().wordPattern(pattern = "abba", s = "dog cat cat fish"))
}