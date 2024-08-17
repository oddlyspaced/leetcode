package medium

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Problem624 {
    fun maxDistance(arrays: List<List<Int>>): Int {
        var curSmallest = arrays[0].first()
        var curLargest = arrays[0].last()
        var dist = 0

        for (index in 1..<arrays.size) {
            val array = arrays[index]
            val tempSmallest = array.first()
            val tempLargest = array.last()
            val tempDist1 = abs(curLargest - tempSmallest)
            val tempDist2 = abs(tempLargest - curSmallest)

            dist = max(dist, max(tempDist1, tempDist2))
            curLargest = max(curLargest, tempLargest)
            curSmallest = min(curSmallest, tempSmallest)
        }
        return dist
    }
}

fun main() {
    println(
        Problem624().maxDistance(
            listOf(
                listOf(
                    -2
                ),
                listOf(
                    -3, -2, 1
                ),
//                listOf(
//                    1, 2, 3
//                )
            )
        )
    )
}