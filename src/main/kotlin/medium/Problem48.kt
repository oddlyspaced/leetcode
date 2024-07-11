package medium

class Problem48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        matrix.forEach {
            println(it.joinToString(","))
        }

        var left = 0
        var right = matrix.size - 1

        while (left < right) {
            for (i in 0..(right - left)) {
                val top = left
                val bottom = right
                // temp = top left
                val t = matrix[top][left + i]
                // bottom left to top left
                matrix[top][left + i] = matrix[bottom - i][left]
                matrix[bottom - i][left] = matrix[bottom][right - i]
                matrix[bottom][right - i] = matrix[top + i][right]
                matrix[top + i][right] = t
            }

            left++
            right--
        }

        println()
        matrix.forEach {
            println(it.joinToString(","))
        }
    }
}

fun main() {
    Problem48().rotate(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )
    )
}