package old.medium

import kotlin.math.abs

class Problem1769 {
    fun minOperations(boxes: String): IntArray {
        // need to find dist of other point for every index
        val res = IntArray(boxes.length)
        for (i in boxes.indices) {
            var distSum = 0
            for (j in boxes.indices) {
                if (i != j && boxes[j] == '1') {
                    distSum += abs(j - i)
                }
            }
            res[i] = distSum
        }
        return res
    }
}

fun main() {
    println(Problem1769().minOperations("110").joinToString(","))
    println(Problem1769().minOperations("001011").joinToString(","))
}