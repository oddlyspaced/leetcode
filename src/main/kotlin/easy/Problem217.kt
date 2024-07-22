package easy

class Problem217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val data = HashSet<Int>()
        nums.forEach {
            if (!data.add(it)) {
                return true
            }
        }
        return false
    }
}