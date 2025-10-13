package old.medium

class Problem912 {

    private fun heapify(nums: IntArray, N: Int, i: Int) {
        var largest = i
        val l = 2 * i + 1
        val r = 2 * i + 2

        if (l < N && nums[l] > nums[largest]) {
            largest = l
        }
        if (r < N && nums[r] > nums[largest]) {
            largest = r
        }
        if (largest != i) {
            val t = nums[i]
            nums[i] = nums[largest]
            nums[largest] = t

            heapify(nums, N, largest)
        }
    }

    private fun sort(nums: IntArray) {
        val N = nums.size
        for (i in (N / 2 - 1) downTo 0) {
            heapify(nums, N, i)
        }

        for (i in N - 1 downTo 1) {
            // Move current root to end
            val temp = nums[0]
            nums[0] = nums[i]
            nums[i] = temp

            // call max heapify on the reduced heap
            heapify(nums, i, 0)
        }
    }


    fun sortArray(nums: IntArray): IntArray {
        sort(nums)
        return nums
    }
}

fun main() {
    println(Problem912().sortArray(intArrayOf(5, 4, 1, 10)).joinToString(","))
}