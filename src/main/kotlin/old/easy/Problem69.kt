package old.easy

class Problem69 {
    fun mySqrt(x: Int): Int {
        if (x == 0) {
            return 0
        }

        var v = 1L
        for (i in 1L..(x / 2)) {
            val t = i * i
            if (t > x) {
                break
            }
            v = i
        }
        return v.toInt()
    }
}

fun main() {
    println(Problem69().mySqrt(2147483647))
}