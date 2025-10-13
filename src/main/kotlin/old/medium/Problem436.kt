package old.medium

class Problem436 {
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        val res = IntArray(intervals.size)
        var index = 0
        intervals.forEachIndexed { i, v1 ->
            var ind = -1
            var temp = Int.MAX_VALUE
            for (j in intervals.indices) {
                if (intervals[j][0] >= v1[1]) {
                    if (temp > intervals[j][0]) {
                        ind = j
                        temp = intervals[j][0]
                    }
                }
            }
            res[index++] = ind
        }
        return res
    }
}

fun main() {
    println(
        Problem436().findRightInterval(
            arrayOf(
                intArrayOf(3, 4),
                intArrayOf(2, 3),
                intArrayOf(1, 2),
            )
        ).joinToString(",")
    )
}