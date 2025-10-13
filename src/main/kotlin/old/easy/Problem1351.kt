package old.easy

class Problem1351 {
    fun countNegatives(grid: Array<IntArray>): Int {
        var c = 0
        for (row in grid) {
            var l = 0
            var r = row.size - 1
            while (l <= r) {
                val mid = (l + r) / 2
                if (row[mid] < 0) {
                    r = mid - 1
                } else {
                    l = mid + 1
                }
            }
            c += (row.size - l)

        }
        return c
    }
}

fun main() {
    println(
        Problem1351().countNegatives(
            arrayOf(
                intArrayOf(5, 4, 3, 2, -1),
                intArrayOf(4, 3, 2, 1, -1),
                intArrayOf(2, 1, 1, -1, -2),
                intArrayOf(0, -1, -1, -2, -3),
            )
        )
    )
}