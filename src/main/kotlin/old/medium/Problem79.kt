package old.medium

class Problem79 {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        var exists = false
//        var r = 0
//        var c = 0
//        while (r < board.size && c < board[0].size) {
//
//        }
        for (r in board.indices) {
            for (c in board[0].indices) {
                // first we find starting point
                if (word[0] == board[r][c]) {
                    // starting point found
                    var rr = r
                    var cc = c

                }
            }
        }
        return false
    }
}

fun main() {
    println(
        Problem79().exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "ABCCED"
        )
    )
}