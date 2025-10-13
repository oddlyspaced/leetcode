package old.medium

class Problem38 {
    private fun rle(s: String): String {
        var count = 0
        var cur = ' '
        val res = StringBuilder()
        for (c in s) {
            if (c != cur) {
                // new character
                if (count > 0) {
                    res.append(count).append(cur)
                }
                cur = c
                count = 1
            } else {
                count++
            }
        }
        res.append(count).append(cur)
        return res.toString()
    }

    fun countAndSay(n: Int): String {
        var cur = "1"
        for (i in 1..<n) {
            cur = rle(cur)
        }
        return cur
    }
}

fun main() {
    println(Problem38().countAndSay(1))
    println(Problem38().countAndSay(2))
    println(Problem38().countAndSay(3))
    println(Problem38().countAndSay(4))
}