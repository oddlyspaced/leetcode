package easy

class Problem58 {
    fun lengthOfLastWord(s: String): Int {
        return s.split(" ").last { it.isNotEmpty() }.length
    }
}

fun main() {
    println(Problem58().lengthOfLastWord("   fly me   to   the moon  "))
}