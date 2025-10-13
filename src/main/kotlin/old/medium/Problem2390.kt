package old.medium

class Problem2390 {
    fun removeStars(s: String): String {
        val chars = ArrayDeque<Char>()
        s.forEach { chars.add(it) }

        val res = StringBuilder()
        var starCount = 0
        while (chars.isNotEmpty()) {
            val t = chars.removeLast()
            if (t == '*') {
                starCount++
            } else {
                if (starCount > 0) {
                    starCount--
                } else {
                    res.insert(0, t)
                }
            }
        }
        return res.toString()
    }
}

fun main() {
    println(Problem2390().removeStars("leet**cod*e"))
    println(Problem2390().removeStars("erase*****"))
}