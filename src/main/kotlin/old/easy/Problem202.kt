package old.easy

class Problem202 {
    fun sumDigit(n: Int): Int {
        var res = 0
        var n = n
        while (n > 0) {
            val dig = n % 10
            res += (dig * dig)
            n = n / 10
        }
        return res
    }

    fun isHappy(n: Int): Boolean {
        var n = n
        while (n > 1) {
            n = sumDigit(n)
        }
        return true
    }
}

fun main() {
    var n = 7
    repeat(10) {
        println(n)
        n = Problem202().sumDigit(n)
    }
}