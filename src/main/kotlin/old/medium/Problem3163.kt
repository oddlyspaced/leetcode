package old.medium

class Problem3163 {
    private fun findPrefix(str: String): String {
        var i = 1
        val res = StringBuilder()
        res.append(str[0])
        while (i < minOf(9, str.length)) {
            if (str[i] != res.last()) {
                return res.toString()
            }
            res.append(str[i])
            i++
        }
        return res.toString()
    }

    fun compressedString(word: String): String {
        var i = 0
        val res = StringBuilder()
        while (i < word.length) {
            val pre = findPrefix(word.substring(i))
            res.append(pre.length)
            res.append(pre[0])
            i += pre.length
        }
        return res.toString()
    }
}

fun main() {
    println(old.medium.Problem3163().compressedString("abcde"))
    println(old.medium.Problem3163().compressedString("aaaaaaaaaaaaaabb"))
}