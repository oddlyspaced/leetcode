package easy

class Problem455 {
    fun findContentChildren(children: IntArray, s: IntArray): Int {
        val cookies = s.toMutableList().apply {
            sort()
        }
        var res = 0
        for (i in children.indices) {
            if (cookies.isEmpty()) {
                break
            } else {
                val curChildGreed = children[i]
                // find if a cookie exists that can satisfy
                var cookieExists = false
                for (cookie in cookies) {
                    if (cookie >= curChildGreed) {
                        cookieExists = true
                        cookies.remove(cookie)
                        break
                    }
                }
                if (cookieExists) {
                    res++
                }
            }
        }
        return res
    }
}

fun main() {
    println(Problem455().findContentChildren(intArrayOf(1, 2, 3), intArrayOf(1, 1)))
    println(Problem455().findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
}