package easy

class Problem1894 {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        var total = 0L
        chalk.forEach { total += it }
        var sum = k % total
        for (i in chalk.indices) {
            println("SUM : $sum")
            if (sum < chalk[i])
                return i
            sum -= chalk[i]
        }
        return 0

    }
}

fun main() {
    println(Problem1894().chalkReplacer(intArrayOf(5, 1, 5), 22))
    println(Problem1894().chalkReplacer(intArrayOf(3, 4, 1, 2), 25))
}