package old.medium

class Problem885 {
    fun spiralMatrixIII(rows: Int, cols: Int, rStart: Int, cStart: Int): Array<IntArray> {
        val dirs = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))
        val res = Array(rows * cols) { IntArray(2) }
        var index = 0
        var r = rStart
        var c = cStart
        var steps = 1
        var i = 0
        while (index < (rows * cols)) {
            // perform 2 dirs at a time
            repeat(2) {
                val dir = dirs[i]
                repeat(steps) {
                    if (r in 0..<rows && c in 0..<cols) {
                        res[index++] = intArrayOf(r, c)
                    }
                    r += dir[0]
                    c += dir[1]
                }
                i = (i + 1) % 4
            }
            steps++
        }
        return res
    }
}

fun main() {
    Problem885().spiralMatrixIII(1, 4, 0, 0).forEach {
        println(it.joinToString(","))
    }
}