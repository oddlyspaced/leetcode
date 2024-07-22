package easy

class EasyProblem1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (nums.size == 2) {
            return intArrayOf(0, 1)
        }
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { index, i ->
            val rem = target - i
            if (map[rem] != null) {
                return intArrayOf(map[rem]!!, index)
            }
            map[i] = index
        }

        return intArrayOf(0, 1)
    }
}

fun main() {
    print(EasyProblem1().twoSum(intArrayOf(2, 7, 11, 15), 9).joinToString(","))
}