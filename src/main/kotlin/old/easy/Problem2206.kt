package old.easy

class Problem2206 {
    fun divideArray(nums: IntArray): Boolean {
        val counts = hashMapOf<Int, Int>()
        nums.forEach {
            counts[it] = (counts.getOrDefault(it, 0)) + 1
        }
        counts.forEach {
            if (it.value % 2 == 1) {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(Problem2206().divideArray(intArrayOf(3, 2, 3, 2, 2, 2)))
}