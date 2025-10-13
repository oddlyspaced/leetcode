package old.easy

/**
 * Created by Hardik Srivastava on 09/04/25
 */
class Problem3375 {
    fun minOperations(nums: IntArray, k: Int): Int {
        if (k > nums.min()) {
            return  -1
        }
        val uniqueNums = nums.toSet()
        if (uniqueNums.contains(k)) {
            return uniqueNums.size - 1
        }
        return uniqueNums.size
    }
}