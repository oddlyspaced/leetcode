package grind75

/**
 * Created by Hardik Srivastava on 15/10/25
 */
// https://leetcode.com/problems/valid-parentheses/
class Problem20 {
    fun isValid(s: String): Boolean {
        if (s.length == 1) {
            return false
        }
        val stack = ArrayDeque<Char>()
        s.forEach {
            if (it == '(' || it == '[' || it == '{') {
                stack.addLast(it)
            } else {
                if (stack.isEmpty()) {
                    return false
                }
                val last = stack.last()
                if (it == ')' && last != '(') {
                    return false
                } else if (it == ']' && last != '[') {
                    return false
                } else if (it == '}' && last != '{') {
                    return false
                } else {
                    stack.removeLast()
                }
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    println(Problem20().isValid("()"))
    println(Problem20().isValid("()[]{}"))
    println(Problem20().isValid("(]"))
    println(Problem20().isValid("([])"))
    println(Problem20().isValid("([)]"))
    println(Problem20().isValid(")(){}"))
    println(Problem20().isValid("(])"))
}

/**
 * 1 ]
 */