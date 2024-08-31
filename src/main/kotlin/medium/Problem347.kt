package medium

class Problem347 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val count = hashMapOf<Int, Int>()
        nums.forEach {
            count[it] = count.getOrDefault(it, 0) + 1
        }

        val res = IntArray(k)
        var resIndex = 0
        repeat(k) {
            // find max
            val maxK = count.maxBy {
                it.value
            }
            res[resIndex++] = maxK.key
            count[maxK.key] = 0
        }
        return res
    }
}

fun main() {
    println(Problem347().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).joinToString(","))
}