package old.medium

class Medium56 {

    // 1, 3 // 2, 6
    // 2, 6 // 1, 3

    private fun checkOverlap(range1: IntArray, range2: IntArray): Boolean {
        // [1,4],[0,4]
        // 0 4 // 1 4
        return if (range1[1] >= range2[0]) {
            true
        } else if (range1[0] <= range2[1]) {
            true
        } else {
            false
        }
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val res = arrayListOf<IntArray>()
        var c = 0
        while (c < intervals.size) {
            val first = intervals[c]
            var d = c + 1
            var flag = false
            while (d < intervals.size) {
                val second = intervals[d]
                if (checkOverlap(first, second)) {
                    res.add(intArrayOf(first[0], second[1]))
                    c = d + 1
                    flag = true
                    break
                } else {
                    d++
                }
            }
            if (!flag) {
                res.add(intervals[c])
                c += 1
            }
        }
        return res.toTypedArray()
    }
}

fun main() {
    Medium56().merge(
        arrayOf(
            intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)
        )
    ).forEach {
        println(it.joinToString(","))
    }

    Medium56().merge(
        arrayOf(
            intArrayOf(1, 4), intArrayOf(4, 5)
        )
    ).forEach {
        println(it.joinToString(","))
    }
}