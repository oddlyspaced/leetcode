package medium

class Problem54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var counter = 0

        var maxCol = matrix[0].size
        var maxRow = matrix.size

        var r = 0
        var c = 0

        while (counter < (matrix.size * matrix[0].size)) {
            println(matrix[r][c])

            if (c == maxCol) {

            }

            counter++
        }
        return listOf()
    }
}

fun main() {
    println(
        Problem54().spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
            )
        )
    )
}