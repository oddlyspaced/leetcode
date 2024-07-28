package medium

class Problem74 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size

        var l = 0
        var r = m - 1

        var row = matrix[0]

        while (l <= r) {
            val mid = (l + r) / 2
            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                row = matrix[mid]
                break
            } else if (target < matrix[mid][0]) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

        l = 0
        r = n - 1

        println(row.joinToString(","))

        if (target >= row[0] && target <= row[n - 1]) {
            while (l <= r) {
                val mid = (l + r) / 2
                if (target == row[mid]) {
                    return true
                } else if (target > row[mid]) {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }
        }

        return false
    }
}

fun main() {
    println(
        Problem74().searchMatrix(
            arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 60)
            ),
            3
        )
    )
//
    println(
        Problem74().searchMatrix(
            arrayOf(
                intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 50)
            ),
            10
        )
    )
}