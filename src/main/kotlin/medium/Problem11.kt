package medium

import kotlin.math.min

class Problem11 {
    fun maxArea(height: IntArray): Int {
        var max = 0
        for (i in height.indices) {
            for (j in i..<height.size) {
                val min = min(height[i], height[j])

                val t = (min * (j - i))
                if (t > max) {
                    max = t
                }
            }
        }
        return max
    }
}

fun main() {
    println(Problem11().maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}