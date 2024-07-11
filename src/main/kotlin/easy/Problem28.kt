package easy

class EasyProblem28 {
    fun strStr(haystack: String, needle: String): Int {
        return haystack.indexOf(needle)
    }
}

fun main() {
    println(EasyProblem28().strStr("sadbutsad", "sad"))
}