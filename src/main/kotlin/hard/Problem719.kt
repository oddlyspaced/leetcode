package hard

import kotlin.math.abs
import kotlin.random.Random

class Problem719 {

    private fun quickSelect(nums: IntArray, k: Int): Int {
        return quickSelectHelper(nums, 0, nums.size - 1, k - 1)
    }

    private fun quickSelectHelper(nums: IntArray, left: Int, right: Int, k: Int): Int {
        if (left == right) return nums[left]

        val pivotIndex = partition(nums, left, right)

        return when {
            k == pivotIndex -> nums[k]
            k < pivotIndex -> quickSelectHelper(nums, left, pivotIndex - 1, k)
            else -> quickSelectHelper(nums, pivotIndex + 1, right, k)
        }
    }

    private fun partition(nums: IntArray, left: Int, right: Int): Int {
        val pivot = nums[right]
        var i = left

        for (j in left until right) {
            if (nums[j] <= pivot) {
                nums.swap(i, j)
                i++
            }
        }
        nums.swap(i, right)
        return i
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        val dist = IntArray(nums.size * (nums.size - 1) / 2)
        var index = 0
        for (i in nums.indices) {
            for (j in ((i + 1)..<nums.size)) {
                dist[index++] = (abs(nums[j] - nums[i]))
            }
        }
        println("DIST : " + dist.joinToString(","))
        return quickSelect(dist, k)
    }
}

fun main() {
    println(Problem719().smallestDistancePair(intArrayOf(1, 3, 1), 1))
    println(Problem719().smallestDistancePair(intArrayOf(1, 6, 1), 3))
    println(Problem719().smallestDistancePair(intArrayOf(62, 100, 4), 3))
}