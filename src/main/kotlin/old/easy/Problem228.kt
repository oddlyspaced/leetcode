package old.easy

class Problem228 {
    fun summaryRanges(nums: IntArray): List<String> {
        val data = arrayListOf<String>()
        var index = 0
        var start = 0
        while (index < nums.size - 1) {
            if (nums[index + 1] - nums[index] != 1) {
                if (start == index) {
                    data.add("${nums[start]}")
                } else {
                    data.add("${nums[start]}->${nums[index]}")
                }
                start = index + 1
            }
            index++
        }
        if (start == nums.size - 1) {
            data.add("${nums[start]}")
        } else {
            data.add("${nums[start]}->${nums[nums.size - 1]}")
        }

        return data
    }
}

fun main() {
    println(Problem228().summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)))
    println(Problem228().summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)))
}