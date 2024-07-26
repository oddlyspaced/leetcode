package easy

import java.util.TreeSet

class Problem1636 {
    fun frequencySort(nums: IntArray): IntArray {
        val freq = hashMapOf<Int, Int>()
        nums.forEach {
            freq[it] = (freq[it] ?: 0) + 1
        }

        val data = hashMapOf<Int, TreeSet<Int>>()
        freq.keys.forEach { key ->
            val f = freq[key]!!
            if (data[f] == null) {
                data[f] = TreeSet<Int>(compareBy { it })
            }
            data[f]!!.add(key)
        }

        var index = 0
        data.keys.sorted().forEach { rep ->
            println("DATA : $rep ${data[rep]?.joinToString(",")}")
            data[rep]!!.reversed().forEach { num ->
                repeat(rep) {
                    nums[index++] = num
                }
            }
        }

        return nums
    }
}

fun main() {
//    println(Problem1636().frequencySort(intArrayOf(-1, 1, -6, 4, 5, -6, 1, 4, 1)).joinToString(","))
    println(
        Problem1636().frequencySort(
            intArrayOf(
                -53,
                -53,
                52,
                52,
                52,
                52,
                -53,
                -53,
                52,
                -53,
                52,
                52,
                52,
                -53,
                52,
                52,
                -53,
                52,
                -53,
                52,
                -53,
                52,
                52,
                52,
                52,
                52,
                52,
                52,
                52,
                52,
                -53,
                52,
                -53,
                52,
                -53,
                52,
                52,
                52,
                -53,
                -53,
                52,
                -53,
                52,
                52,
                52,
                52,
                -53,
                -53,
                -53,
                -53,
                -53,
                52,
                52,
                -53,
                52,
                -53,
                52,
                52,
                52
            )
        ).joinToString(",")
    )
}