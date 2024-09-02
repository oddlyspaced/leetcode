package easy

class Problem1894 {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        var k = k
        var i = 0
        while (k >= chalk[i]) {
            k -= chalk[i]
            i++
            if (i == chalk.size) {
                i = 0
            }
        }
        return i
    }
}