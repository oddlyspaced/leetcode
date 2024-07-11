package medium

class Problem54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val res = arrayListOf<Int>()
        var counter = 0

        var dirRow = 1
        var dirCol = 1
        var dir = 1 // 1 = col change

        var maxCol = matrix[0].size
        var maxRow = matrix.size
        var minCol = 0
        var minRow = 0

        var r = 0
        var c = 0

        while (counter < (matrix.size * matrix[0].size)) {
            println(matrix[r][c])
            if (dir == 1) {
                c = c + dirCol
            } else if (dir == 0) {
                r = r + dirRow
            }
//            println("R C $r $c $maxRow $maxCol")
            if (c == maxCol || c == minCol) {
                maxCol--
                minCol++
                dir = 0

//                r = r + dirRow
            } else if (r == maxRow || r == minRow) {
                maxRow--
                minRow++
                dir = 1

            }
            counter++
        }
        return res
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