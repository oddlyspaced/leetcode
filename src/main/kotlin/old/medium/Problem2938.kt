package old.medium

class Problem2938 {
    fun minimumSteps(s: String): Long {
        var zero = 0
        var steps = 0L
        for (i in s.indices) {
            if (s[i] == '0') {
                steps += i - zero
                zero += 1
            }
        }
        return steps
    }
}

fun main() {
    println(Problem2938().minimumSteps("101"))
    println(Problem2938().minimumSteps("100"))
    println(Problem2938().minimumSteps("11000111"))
}