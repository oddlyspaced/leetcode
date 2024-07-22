package medium

class Problem347 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val count = HashMap<Int, Int>()
        nums.forEach {
            count[it] = (count[it] ?: 0) + 1
        }
        val res = IntArray(k)
        var index = 0
        repeat(k) {
            var hK = 0
            var hV = 0
            count.forEach { (key, value) ->
                if (value > hV) {
                    hV = value
                    hK = key
                }
            }
            res[index++] = hK
            count[hK] = 0
        }
        return res
    }
}

fun main() {
    println(Problem347().topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).joinToString(","))
}