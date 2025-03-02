package easy

import java.util.TreeMap

class Problem2570 {
    fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
        val res = TreeMap<Int, Int>()
        nums1.forEach { arr ->
            res[arr[0]] = (res[arr[0]] ?: 0) + arr[1]
        }
        nums2.forEach { arr ->
            res[arr[0]] = (res[arr[0]] ?: 0) + arr[1]
        }
        val ids = res.keys.toTypedArray()
        val resArray = Array(ids.size) {
            intArrayOf(ids[it], res[ids[it]]!!)
        }
        return resArray
    }
}

fun main() {
    println(
        Problem2570().mergeArrays(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(4, 5)
            ),
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(3, 2),
                intArrayOf(4, 1)
            )
        ).joinToString { it.joinToString(",") })
}