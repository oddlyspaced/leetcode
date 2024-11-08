package medium

class Problem1829 {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val res = IntArray(nums.size)
        var xorRes = 0
        nums.forEach {
            xorRes = xorRes xor it
        }
        // max value wrt maximumbit
        val maxVal = (1 shl maximumBit) - 1
        for (i in nums.indices.reversed()) {
            res[nums.size - 1 - i] = xorRes xor maxVal
            xorRes = xorRes xor nums[i]
        }
        return res
    }
}