package easy

class Problem1957 {
    fun makeFancyString(s: String): String {
        val sb = StringBuilder()
        for (i in s.indices) {
            if (sb.length > 1) {
                if (sb.last() == s[i] && sb[sb.length - 2] == s[i]) {
                    continue
                } else {
                    sb.append(s[i])
                }
            } else {
                sb.append(s[i])
            }
        }
        return sb.toString()
    }
}

fun main() {
    println(Problem1957().makeFancyString("leeetcode"))
    println(Problem1957().makeFancyString("aaabaaaa"))
}