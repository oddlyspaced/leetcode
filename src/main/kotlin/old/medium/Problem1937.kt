package old.medium

import kotlin.math.abs
import kotlin.math.max

class Problem1937 {
    fun maxPoints(points: Array<IntArray>): Long {
        val source = Array(points.size) { i ->
            LongArray(points[0].size) { j ->
                points[i][j].toLong()
            }
        }
        for (index in 1..<points.size) {
            val prev = source[index - 1]
            val cur = source[index]
            val res = LongArray(cur.size) { cur[it] }
            for (i in points[1].indices) {
                for (j in points[1].indices) {
                    res[i] = max(res[i], (cur[i] + prev[j] - abs(j - i)))
                }
            }
            source[index] = res
        }
        return source.last().max()
    }
}

/*
 var prev = points[0]
        var cur = points[1]
        var res = LongArray(cur.size) { cur[it].toLong() }
        for (i in points[1].indices) {
            for (j in points[1].indices) {
                res[i] = max(res[i], (cur[i] + prev[j] - abs(j - i)).toLong())
            }
        }
        println(res.joinToString(","))
 */

fun main() {
    println(
        Problem1937().maxPoints(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(1, 5, 1),
                intArrayOf(3, 1, 1)
            )
        )
    )

    println(
        Problem1937().maxPoints(
            arrayOf(
                intArrayOf(1, 5),
                intArrayOf(2, 3),
                intArrayOf(4, 2)
            )
        )
    )

    println(
        Problem1937().maxPoints(
            arrayOf(
                intArrayOf(0, 3, 0, 4, 2),
                intArrayOf(5, 4, 2, 4, 1),
                intArrayOf(5, 0, 0, 5, 1),
                intArrayOf(2, 0, 1, 0, 3)
            )
        )
    )

    println(
        Problem1937().maxPoints(
            arrayOf(
                intArrayOf(2, 4, 0, 5, 5),
                intArrayOf(0, 5, 4, 2, 5),
                intArrayOf(2, 0, 2, 3, 1),
                intArrayOf(3, 0, 5, 5, 2)
            )
        )
    )

    println(
        Problem1937().maxPoints(
            arrayOf(
                intArrayOf(1, 5),
                intArrayOf(3, 2),
                intArrayOf(4, 2),
            )
        )
    )


}