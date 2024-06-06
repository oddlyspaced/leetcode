package easy

class EasyProblem1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (nums.size == 2) {
            return intArrayOf(0, 1)
        }
        for (i in nums.indices) {
            val rem = target - nums[i]
            for (j in (i + 1)..<nums.size) {
                if (nums[j] == rem) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf(0, 1)
    }
}

fun main() {
    print(EasyProblem1().twoSum(intArrayOf(3, 3), 6).joinToString(","))
}