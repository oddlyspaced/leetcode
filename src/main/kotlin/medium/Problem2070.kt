package medium

import java.util.TreeMap

class Problem2070 {
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        items.sortBy { it[0] }

        val maxBeautyByPrice = TreeMap<Int, Int>()
        var maxBeauty = 0

        for ((price, beauty) in items) {
            maxBeauty = maxOf(maxBeauty, beauty)
            maxBeautyByPrice[price] = maxBeauty
        }

        return queries.map { query ->
            maxBeautyByPrice.floorEntry(query)?.value ?: 0
        }.toIntArray()
    }
}

fun main() {
    println(
        Problem2070().maximumBeauty(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 2),
                intArrayOf(2, 4),
                intArrayOf(5, 6),
                intArrayOf(3, 5),
            ),
            intArrayOf(1, 2, 3, 4, 5, 6)
        ).joinToString(",")
    )
}