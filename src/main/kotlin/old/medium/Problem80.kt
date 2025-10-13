package old.medium

class Problem80 {
    fun removeDuplicates(nums: IntArray): Int {
        var uniq = 1
        var repCount = 0
        var index = 0
        var temp = nums[0]
        var nIndex = 0
        while (index < nums.size) {
            if (nums[index] != temp) {
                temp = nums[index]
                uniq++
                repCount = 0
            }
            if (repCount < 2) {
                nums[nIndex] = nums[index]
                repCount++
                nIndex++
                uniq++
            }
            index++
        }
        println(nums.joinToString(","))
        return uniq
    }
}

fun main() {
    println(Problem80().removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)))
    println(Problem80().removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)))
    // 1, 1, 2, 2, 3, _
}