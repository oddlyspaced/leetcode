package old.easy

class Problem70 {
    fun climbStairs(n: Int): Int {
        return climb(0, n)
    }

    fun climb(current: Int, n: Int): Int {
        if (current == n) {
            return 1
        } else if (current > n) {
            return 0
        }
        return climb(current + 1, n) + climb(current + 2, n)
    }
}

fun main() {
    println(Problem70().climbStairs(44))
}

// 2 + 2

// 1 + 1 + 2
// 2 + 1 + 1
// 1 + 1 + 1 + 1

// 1 + 2 + 1
