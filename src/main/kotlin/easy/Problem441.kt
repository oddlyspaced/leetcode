package easy

class Problem441 {
    fun arrangeCoins(n: Int): Int {
        var c = 1
        var n = n
        while (n >= c) {
            n -= c++
        }
        return c - 1
    }
}

fun main() {
    println(Problem441().arrangeCoins(11))
}
// 1
// 2 3
// 4 5 6
// 7 8 9 10