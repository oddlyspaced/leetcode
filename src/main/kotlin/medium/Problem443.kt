package medium

class Problem443 {
    fun compress(chars: CharArray): Int {
        var index = 0
        var curChar = chars[0]
        var curCharLen = 1
        for (i in 1..<chars.size) {
            val t = chars[i]
            if (curChar == t) {
                curCharLen++
            } else {
                chars[index++] = curChar
                if (curCharLen > 1) {
                    val num = curCharLen.toString()
                    for (c in num) {
                        chars[index++] = c
                    }
                }
                curChar = t
                curCharLen = 1
            }
        }
        chars[index++] = curChar
        if (curCharLen > 1) {
            val num = curCharLen.toString()
            for (c in num) {
                chars[index++] = c
            }
        }
        println(chars.joinToString(","))
        return index
    }
}

fun main() {
    println(Problem443().compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')))
    println(Problem443().compress(charArrayOf('a')))
    println(Problem443().compress(charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')))
}