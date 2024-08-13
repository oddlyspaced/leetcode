package medium

class Problem840 {
    fun numMagicSquaresInside(grid: Array<IntArray>): Int {
//        val cols = IntArray(3)
//        val rows = IntArray(3)
//        var r = 0
//        var c = 0

//        repeat(3) { i ->
//            repeat(3) { j ->
//                rows[i] = rows[i] + grid[i][j]
//                cols[i] = cols[i] + grid[j][i]
//
//                rows[0] = grid[0][0] + grid[0][1] + grid[0][2]
//                rows[1] = grid[1][0] + grid[1][1] + grid[1][2]
//                rows[2] = grid[2][0] + grid[2][1] + grid[2][2]
//
//                cols[0] = grid[0][0] + grid[1][0] + grid[2][0]
//                cols[1] = grid[0][1] + grid[1][1] + grid[2][1]
//                cols[2] = grid[0][2] + grid[1][2] + grid[2][2]
//            }
//        }
//        println("ROW SUMS : ${rows.joinToString(",")}")
//        println("COL SUMS : ${cols.joinToString(",")}")


        var r = 0
        var c = 0
        var res = 0

        while ((r + 2) < grid.size) {
            while ((c + 2) < grid[0].size) {
                // distinct map
                val digs = hashMapOf<Int, Int>()
                val cols = IntArray(3)
                val rows = IntArray(3)
                val diags = IntArray(2)
                var valid = true

                repeat(3) { i ->
                    repeat(3) { j ->
                        digs[grid[r + i][c + j]] = (digs[grid[r + i][c + j]] ?: 0) + 1
                        rows[i] = rows[i] + grid[r + i][c + j]
                        cols[i] = cols[i] + grid[r + j][c + i]
                    }
                    diags[0] = diags[0] + grid[r + i][c + i]
                    diags[1] = diags[1] + grid[r + i][c + 2 - i]
                }
                c++

                // now validate
                for (i in 1..9) {
                    if (digs[i] != 1) {
                        valid = false
                        break
                    }
                }
                if (valid) {
                    for (rs in rows) {
                        if (rs != 15) {
                            valid = false
                            break
                        }
                    }
                }
                if (valid) {
                    for (cs in cols) {
                        if (cs != 15) {
                            valid = false
                            break
                        }
                    }
                }
                if (valid) {
                    for (ds in diags) {
                        if (ds != 15) {
                            valid = false
                            break
                        }
                    }
                }
                if (valid) {
                    res++
                }
//                println("AAAA ${rows.joinToString(",")}")
//                println("AAAA C ${cols.joinToString(",")}")
//                println("DIAGs C ${diags.joinToString(",")}")
//                println("---")
            }
            r++
            c = 0
        }
        return res
    }
}

fun main() {
    println(
        Problem840().numMagicSquaresInside(
            arrayOf(
                intArrayOf(4, 3, 8, 4),
                intArrayOf(9, 5, 1, 9),
                intArrayOf(2, 7, 6, 2)
            )
        )
    )

//    println(
//        Problem840().numMagicSquaresInside(
//            arrayOf(
//                intArrayOf(1, 4, 0, 2),
//                intArrayOf(2, 10, 8, 1),
//                intArrayOf(3, 6, 9, 1)
//            )
//        )
//    )
}