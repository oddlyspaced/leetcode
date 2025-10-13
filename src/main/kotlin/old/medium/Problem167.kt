package old.medium

class Problem167 {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            if (sum == target) {
                break
            }
            else if (sum > target) {
                right--
            }
            else if (sum < target) {
                left++
            }
        }
        return intArrayOf(left + 1, right + 1)
    }
}

fun main() {
    println(Problem167().twoSum(intArrayOf(-1, 0), -1).joinToString(","))
}