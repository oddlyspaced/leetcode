package old.easy

class Problem2379 {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var wc = 0
        for (i in 0..<k) {
            if (blocks[i] == 'W') {
                wc++
            }
        }
        var res = wc
        var l = 0
        var r = k
        while (r < blocks.length) {
            if (blocks[r] == 'W') {
                wc++
            }
            if (blocks[l] == 'W') {
                wc--
            }
            res = minOf(res, wc)
            l++
            r++
        }
        return if (res > 0) res else 0
    }
}

fun main() {
    println(Problem2379().minimumRecolors("WBBWWBBWBW", 7))
    println(Problem2379().minimumRecolors("WBWBBBW", 2))
    println(Problem2379().minimumRecolors("BWWWBB", 6))
}