package easy

class Problem977 {
    fun sortedSquares(nums: IntArray): IntArray {
        val size = nums.size

        var left = 0
        var right = nums.size - 1
        val result = IntArray(size)

        nums.forEachIndexed { index, i ->
            nums[index] = i * i
        }

        println("NUMS : ${nums.joinToString(",")}")
        var index = nums.size - 1
        while (left <= right) {
            println("L $left R $right")
            if (nums[left] <= nums[right]) {
                result[index] = nums[right]
                right--
            } else {
                result[index] = nums[left]
                left++
            }
            index--
        }
        return result
    }
}

fun main() {
    println(Problem977().sortedSquares(intArrayOf(-11, -4, -1, 0, 3, 4, 10)).joinToString(","))
}