package easy

class Problem344 {
    fun reverseString(s: CharArray): Unit {
        for (i in 0..<s.size / 2) {
            val t = s[i]
            s[i] = s[s.size - 1 - i]
            s[s.size - 1 - i] = t
        }
    }
}

fun main() {
    Problem344().reverseString(charArrayOf('a', 'b', 'c', 'd', 'e', 'f'))
}