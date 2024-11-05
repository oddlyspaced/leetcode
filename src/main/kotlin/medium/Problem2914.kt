package medium

class Problem2914 {
    fun minChanges(s: String): Int {
        return s.chunked(2).map {
            if (it[0] == it[1]) 0 else 1
        }.sum()
    }
}

fun main() {
    println(Problem2914().minChanges("1001"))
    println(Problem2914().minChanges("10"))
    println(Problem2914().minChanges("0000"))
    println(Problem2914().minChanges("11000111"))
}