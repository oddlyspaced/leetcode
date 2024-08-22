package medium

class Problem739 {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val res = IntArray(temperatures.size)
        for (i in temperatures.indices) {
            for (j in (i + 1)..<temperatures.size) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i
                    break
                }
            }
        }
        return res
    }
}

fun main() {
    println(Problem739().dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).joinToString(","))
}