package medium

class Problem73 {
    fun setZeroes(matrix: Array<IntArray>) {
        val R = matrix.size - 1
        val C = matrix[0].size - 1

        val zeroes = arrayListOf<IntArray>()

        for (i in 0..R) {
            for (j in 0..C) {
                if (matrix[i][j] == 0) {
                    zeroes.add(intArrayOf(i, j))
                }
            }
        }

        zeroes.forEach {
//            println(it.joinToString(","))
            val nr = it[0]
            val nc = it[1]

            for (i in 0..R) {
                matrix[i][nc] = 0
            }
            for (j in 0..C) {
                matrix[nr][j] = 0
            }
        }

        matrix.forEach {
            println(it.joinToString(","))
        }
    }
}

fun main() {
//    Problem73().setZeroes(
//        arrayOf(
//            intArrayOf(1, 1, 1),
//            intArrayOf(1, 0, 1),
//            intArrayOf(1, 1, 1)
//        )
//    )

    Problem73().setZeroes(
        arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5)
        )
    )
}