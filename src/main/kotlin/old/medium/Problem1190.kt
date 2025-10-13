package old.medium

class Problem1190 {
    fun reverseParentheses(s: String): String {
//        var s = "($s)"
        val sb = StringBuilder()
        val bracket = ArrayDeque<Char>()
        val ind = ArrayDeque<Int>()
        var index = 0
        while (index < s.length) {
            if (s[index] == '(') {
//                bracket.addLast('(')
//                ind.addLast(index + 1)
            } else if (s[index] == ')') {
                bracket.removeLast()
                val t = ind.removeLast()
//                println(s.substring(t, index))
                var s = t
                var e = index - 1
                while (s < e) {
                    val temp = sb[e]
                    sb.setCharAt(e--, sb[s])
                    sb.setCharAt(s++, temp)
                }
            } else {
                sb.append(s[index])
            }
            index++
        }
        return sb.toString()
    }
}

fun main() {
    println(Problem1190().reverseParentheses("(abcd)"))
    println(Problem1190().reverseParentheses("(ed(et(oc))el)"))
    println(Problem1190().reverseParentheses("ta()usw((((a))))"))
    println(Problem1190().reverseParentheses("ta(q)usw((((a))))"))

}