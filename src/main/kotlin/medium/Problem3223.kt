package medium

class Problem3223 {
    fun minimumLength(s: String): Int {
        val s = StringBuilder(s)
        var run = true
        while (run) {
            for (i in s.indices) {
                val cur = s[i]
                // find if char is in left
                var inLeft = false
                for (j in 0..<i) {
                    if (s[j] == cur) {
                        inLeft = true
                        break
                    }
                }
                // find if char is in right
                var inRight = false
                for (j in (i + 1)..<s.length) {
                    if (s[j] == cur) {
                        inRight = true
                        break
                    }
                }
                if (inLeft && inRight) {
                    s.removeRange()
                }
            }
        }
    }
}

fun main() {
    Problem3223().minimumLength("abaacbcbb")
}