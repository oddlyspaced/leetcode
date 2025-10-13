package old.easy

class EasyProblem26 {
    fun removeDuplicates(nums: IntArray): Int {
        var count = 1
        for (i in 1..<nums.size) {
            if (nums[i - 1] != nums[i]) {
                nums[count++] = nums[i]
            }
        }
        return count
    }
}

fun main() {
    println(EasyProblem26().removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}