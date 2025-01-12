package medium

class Problem2116 {
    fun canBeValid(s: String, locked: String): Boolean {
        val lockedStack = arrayListOf<Int>()
        val unlockedStack = arrayListOf<Int>()
        for (i in s.indices) {
            if (locked[i] == '0') {
                unlockedStack.add(i)
            }
            else if (s[i] == '(') {
                lockedStack.add(i)
            }
            else {
                if (lockedStack.isNotEmpty()) {
                    lockedStack.removeLast()
                }
                else if (unlockedStack.isNotEmpty()) {
                    unlockedStack.removeLast()
                }
                else {
                    return false
                }
            }
        }

        while (lockedStack.isNotEmpty() && unlockedStack.isNotEmpty() && lockedStack.last() < unlockedStack.last()) {
            lockedStack.removeLast()
            unlockedStack.removeLast()
        }
        if (lockedStack.isNotEmpty()) {
            return false
        }
        return unlockedStack.size % 2 == 0
    }
}

fun main() {
    println(Problem2116().canBeValid("))()))", "010100"))
}