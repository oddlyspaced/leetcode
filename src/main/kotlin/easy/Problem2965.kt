package easy

class Problem2965 {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val all = hashSetOf<Int>()
        for (i in 1..(grid.size * grid.size)) {
            all.add(i)
        }
        var dup = -1
        grid.forEach {
            it.forEach { n ->
                if (!all.remove(n)) {
                    dup = n
                }
            }
        }
        return intArrayOf(dup, all.elementAt(0))
    }
}

fun main() {
    println(
        Problem2965().findMissingAndRepeatedValues(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 2)
            )
        ).joinToString(",")
    )
}