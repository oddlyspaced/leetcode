package old.easy

import kotlin.math.pow

class Problem1009 {

    private fun toBase2(n: Int): String {
        var s = StringBuilder()
        var n = n
        while (n > 1) {
            s.insert(0, (n % 2))
            n /= 2
        }
        s.insert(0, (n % 2))
        return s.toString()
    }

    private fun toBase10(n: String): Int {
        var res = 0
        n.forEachIndexed { index, c ->
            if (c == '0') {
                res += (2.0.pow((n.length - 1 - index).toDouble())).toInt()
            }
        }
        return res
    }

    fun bitwiseComplement(n: Int): Int {
        return toBase10(toBase2(n))
    }
}

fun main() {
    println(Problem1009().bitwiseComplement(5))
    println(Problem1009().bitwiseComplement(7))
    println(Problem1009().bitwiseComplement(10))
}