package old.easy

/**
 * Created by Hardik Srivastava on 31/03/25
 */
class Problem3289 {
    fun getSneakyNumbers(nums: IntArray): IntArray {
        val count = hashMapOf<Int, Int>()
        nums.forEach {
            count[it] = count.getOrDefault(it, 0) + 1
        }
        val res = IntArray(2)
        var index = 0
        count.forEach {
            if (it.value == 2) {
                res[index++] = it.key
            }
        }
        return res
    }
}