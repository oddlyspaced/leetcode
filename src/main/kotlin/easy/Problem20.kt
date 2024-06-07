package easy

class EasyProblem20 {
    fun isValid(s: String): Boolean {
        if (s.length % 2 == 1) {
            return false
        }
        val stack = arrayListOf<Char>()
        s.forEachIndexed { i, c ->
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c)
            } else if (stack.isNotEmpty()) {
                if ((c == ')' && stack.last() == '(') || (c == ']' && stack.last() == '[') || (c == '}' && stack.last() == '{')) {
                    stack.removeLast()
                } else {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    println(EasyProblem20().isValid("([}}])"))
}