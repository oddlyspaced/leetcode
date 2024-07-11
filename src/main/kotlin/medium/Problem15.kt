package medium

class Problem15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val op = arrayListOf<List<Int>>()
        for (i in nums.indices) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue
            }
            val a = nums[i]
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                val sum = a + nums[left] + nums[right]
                println("SUM $a ${nums[left]} ${nums[right]} = $sum")
                if (sum == 0) {
                    op.add(listOf(a, nums[left], nums[right]))
                    left++
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++
                    }
                } else if (sum < 0) {
                    left++
                } else {
                    right--
                }
            }
        }
        return op
    }
}

fun main() {
    println(Problem15().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).joinToString(","))
}