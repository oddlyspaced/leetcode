package medium

class Problem1277 {

    private fun checkSquare(matrix: Array<IntArray>, r: Int, c: Int, size: Int): Boolean {
        var flag = true
        for (ii in r..<r + size) {
            if (!flag) {
                break
            }
            for (jj in c..<c + size) {
                if (matrix[ii][jj] == 0) {
                    flag = false
                    break
                }
            }
        }
        return flag
    }

    private fun count(matrix: Array<IntArray>, size: Int): Int {
        var count = 0

        for (i in 0..matrix.size - size) {
            for (j in 0..matrix[0].size - size) {
                if (checkSquare(matrix, i, j, size)) {
                    count++
                }
            }
        }
        return count
    }

    fun countSquares(matrix: Array<IntArray>): Int {
        val side = minOf(matrix.size, matrix[0].size)
        var res = 0
        for (i in 1..side) {
            res += count(matrix, i)
        }
        return res
    }
}

fun main() {
    println(
        Problem1277().countSquares(
            arrayOf(
                intArrayOf(0, 1, 1, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(0, 1, 1, 1)
            )
        )
    )
}