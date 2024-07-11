package easy

class Problem169 {
    fun majorityElement(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (num in nums) {
            map[num] = (map[num] ?: 0) + 1
        }
        map.keys.forEach {
            if ((map[it] ?: 0) > (nums.size / 2)) {
                return it
            }
        }
        return 0;
    }
}