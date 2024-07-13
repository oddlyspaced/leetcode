package easy

class Problem268 {
    fun missingNumber(nums: IntArray): Int {
        var sum = 0
        nums.indices.forEach {
            sum += it + 1
        }
        nums.forEach {
            sum -= it
        }
        return sum
    }
}

fun main() {
    println(Problem268().missingNumber(intArrayOf(3, 0, 1)))
}