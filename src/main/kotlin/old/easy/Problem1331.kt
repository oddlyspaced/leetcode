package old.easy

class Problem1331 {
    fun arrayRankTransform(arr: IntArray): IntArray {
        if (arr.isEmpty()) {
            return intArrayOf()
        }
        val sorted = arr.sorted()

        val ranks = hashMapOf<Int, Int>()
        var rank = 1
        ranks[sorted[0]] = rank

        for (i in 1..<arr.size) {
            if (sorted[i - 1] != sorted[i]) {
                ranks[sorted[i]] = ++rank
            }
        }

        val res = IntArray(arr.size)
        for (i in arr.indices) {
            res[i] = ranks[arr[i]]!!
        }
        return res

    }
}

fun main() {
    println(Problem1331().arrayRankTransform(intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12)).joinToString(","))
}