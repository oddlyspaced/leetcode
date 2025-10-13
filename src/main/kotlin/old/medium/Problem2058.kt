package old.medium

class Problem2058 {
    fun nodesBetweenCriticalPoints(values: IntArray): IntArray {
        var index = 1
        var lastCrit = -1
        var minDist = Int.MAX_VALUE
        var maxDist = Int.MIN_VALUE

        while (index < values.size - 1) {
            val prev = values[index - 1]
            val curr = values[index]
            val next = values[index + 1]


            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                println("POINT $index $curr")
                if (lastCrit == -1) {
                    lastCrit = index
                } else {
                    val dist = index - lastCrit
                    if (dist > maxDist) {
                        maxDist = dist
                    } else if (dist < minDist) {
                        minDist = dist
                    }
                    lastCrit = index
                }
            }
            index++
        }
        return intArrayOf(minDist, maxDist)
    }
}

fun main() {
    println(Problem2058().nodesBetweenCriticalPoints(intArrayOf(5, 3, 1, 2, 5, 1, 2)).joinToString(","))
}