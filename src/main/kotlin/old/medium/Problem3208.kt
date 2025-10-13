package old.medium

class Problem3208 {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        var windowSize = 1
        var res = 0
        for (i in 1..colors.size + k - 2) {
            val cur = i % colors.size
            val prev = (i - 1) % colors.size
            if (colors[cur] != colors[prev]) {
                windowSize++
            }
            else {
                windowSize = 1
            }
            if (windowSize >= k) {
                res++
            }
        }
        return res
    }
}

fun main() {
    println(Problem3208().numberOfAlternatingGroups(intArrayOf(0, 1, 0, 1, 0), 3))
    println(Problem3208().numberOfAlternatingGroups(intArrayOf(0, 1, 0, 0, 1, 0, 1), 6))
    println(Problem3208().numberOfAlternatingGroups(intArrayOf(1, 1, 0, 1), 4))

}