package old.medium;


class Problem54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val res = mutableListOf<Int>()
        var top = 0
        var left = 0
        var bottom = matrix.size - 1
        var right = matrix[0].size - 1
        var dir = 0
        while (top <= bottom && left <= right) {
            when (dir) {
                0 -> {
                    for (i in left until right + 1) {
                        res.add(matrix[left][i])
                    }
                    top++
                }

                1 -> {
                    for (i in top until bottom + 1) {
                        res.add(matrix[i][right])
                    }
                    right--
                }

                2 -> {
                    for (i in right downTo left) {
                        res.add(matrix[bottom][i])
                    }
                    bottom--
                }

                3 -> {
                    for (i in bottom downTo top) {
                        res.add(matrix[i][left])
                    }
                    left++
                }
            }
            dir = (dir + 1) % 4
        }

        return res
    }
}

fun main() {
    println(
        Problem54().spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12)
            )
        ).joinToString(",")
    )
}