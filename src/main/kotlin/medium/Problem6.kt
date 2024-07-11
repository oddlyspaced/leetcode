package medium

class Problem6 {
    fun convert(s: String, numRows: Int): String {
        val matrix = arrayListOf<ArrayList<Char>>()
        repeat(numRows) {
            val row = arrayListOf<Char>()
            repeat(s.length) {
                row.add(' ')
            }
            matrix.add(row)
        }

        var sIndex = 0
        var rIndex = 0
        var cIndex = 0
        var flagDown = true
        while (sIndex < s.length) {
            if (rIndex == numRows - 1 || rIndex == numRows) {
                flagDown = false
                rIndex = numRows - 1
            } else if (rIndex == 0 || rIndex == -1) {
                flagDown = true
                rIndex = 0
            }

            matrix[rIndex][cIndex] = s[sIndex++]
            if (flagDown) {
                // need to go straight downwards
                rIndex++
            } else {
                rIndex--
                cIndex++
            }

        }
        var res = ""
        for (row in matrix) {
            for (v in row) {
                if (v != ' ') {
                    res += v
                }
            }
        }
        return res
    }
}

fun main() {
    println(Problem6().convert("ABC", 1))
}