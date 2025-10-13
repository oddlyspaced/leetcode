package old.easy

import kotlin.math.abs

class Problem1652 {
    fun decrypt(code: IntArray, k: Int): IntArray {
        val res = IntArray(code.size)
        if (k == 0) {
            return res
        }
        for (i in res.indices) {
            var sum = 0
            if (k > 0) {
                for (j in 1..k) {
                    sum += code[(i + j) % code.size]
                }
            } else {
                for (j in k..-1) {
                    var ind = i + j
                    if (ind < 0) {
                        ind += code.size
                    }
                    sum += code[ind]
                }
            }

            res[i] = sum
        }
        return res
    }
}

fun main() {
    println(Problem1652().decrypt(intArrayOf(5, 7, 1, 4), 3).joinToString(","))
    println(Problem1652().decrypt(intArrayOf(1, 2, 3, 4), 0).joinToString(","))
    println(Problem1652().decrypt(intArrayOf(2, 4, 9, 3), -2).joinToString(","))
}