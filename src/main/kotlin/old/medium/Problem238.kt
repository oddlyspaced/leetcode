package old.medium

class Problem238 {
    fun productExceptSelf(nums: IntArray): IntArray {
//        val prefix = IntArray(nums.size)
//        val postfix = IntArray(nums.size)
//
//        var pr = 1
//        var po = 1
//        for (i in nums.indices) {
//            pr *= nums[i]
//            prefix[i] = pr
//            po *= nums[nums.size - 1 - i]
//            postfix[nums.size - 1 - i] = po
//        }
//
//        val res = IntArray(nums.size)
//        for (i in nums.indices) {
//            when (i) {
//                0 -> {
//                    res[i] = postfix[1]
//                }
//                nums.size - 1 -> {
//                    res[i] = prefix[i - 1]
//                }
//                else -> {
//                    res[i] = prefix[i - 1] * postfix[i + 1]
//                }
//            }
//        }

        val res = IntArray(nums.size)
        var pr = 1
        var po = 1

        for (i in nums.indices) {
            res[i] = pr
            pr *= nums[i]
            res[nums.size - 1 - i] *= po
            po *= nums[nums.size - 1 - i]
        }

        return res
    }
}

fun main() {
    println(Problem238().productExceptSelf(intArrayOf(1, 2, 3, 4)).joinToString(","))
    println(Problem238().productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).joinToString(","))
}