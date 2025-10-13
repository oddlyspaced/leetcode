package old.easy

class Problem796 {
    fun rotateString(s: String, goal: String): Boolean {
        fun lShift(str: String): String {
            return str.substring(1, str.length) + str.first()
        }

        fun rShift(str: String): String {
            return str.last() + str.substring(0, str.length - 1)
        }

        var l = lShift(s)
        var r = rShift(s)
        for (i in s.indices) {
            if (l == goal || r == goal) {
                return true
            }
            l = lShift(l)
            r = rShift(r)
        }
        return false
    }
}

fun main() {
    println(Problem796().rotateString(s = "abcde", goal = "cdeab"))
}