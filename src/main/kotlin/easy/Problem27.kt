package easy

class EasyProblem27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        for (i in nums.indices) {
            if (`val` != nums[i]) {
                nums[index++] = nums[i]
            }
        }
        return index
    }
}

fun main() {
    println(EasyProblem27().removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
}