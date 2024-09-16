package medium

import kotlin.math.min

class Problem539 {
    private fun timeToNum(time: String): Int {
        val hours = time.split(":")[0].toInt()
        val mins = time.split(":")[1].toInt()
        return (hours * 60 + mins)
    }

    fun findMinDifference(timePoints: List<String>): Int {
        val times = timePoints.map { timeToNum(it) }.sorted()
        println("TT : " + times.joinToString(","))
        var res = (24 * 60) - (times.last() - times.first())
        println("eEe : " + res)

        for (i in 0..<timePoints.size - 1) {
            val cur = times[i + 1]
            val prev = times[i]
            val diff = cur - prev
            println("DIF : " + diff)
            res = min(res, diff)
            if (res == 0) {
                return 0
            }
        }
        return res
    }
}

fun main() {
    println(Problem539().findMinDifference(listOf("23:59", "00:00")))
    println(Problem539().findMinDifference(listOf("12:12", "12:13")))
}