package medium

class Problem2579 {
    fun coloredCells(n: Int): Long {
        var res = 1L
        for (i in 1..n) {
            res += (4 * (i - 1))
        }
        return res
    }
}

fun main() {
    println(Problem2579().coloredCells(1))
    println(Problem2579().coloredCells(2))
    println(Problem2579().coloredCells(3))
}
/**
 * 1 1
 * 2 5 -> 4
 * 3 13 -> 8
 * 4 25 -> 12
 * 5 41 -> 16
 * 6 61 -> 20
 * 7 85 -> 24
 */