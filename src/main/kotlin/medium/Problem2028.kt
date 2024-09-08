package medium

class Problem2028 {
    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        // (rolls.sum() + x) / (rolls.size + n) = mean
        // rolls.sum() + x = meqn * (rolls.size + n)
        // x = mean * (rolls.size + n) - rolls.sum()
        val x = (mean * (rolls.size + n)) - rolls.sum()
        val res = IntArray(n) {
            x / n
        }
        var rem = x % n
        var index = 0
        while (rem > 0) {
            res[index] += 1
            rem--
            index++
            if (index == res.size) {
                index = 0
            }
        }
        res.forEach {
            if (it > 6) {
                return intArrayOf()
            }
        }
        return res
    }
}

fun main() {
    println(Problem2028().missingRolls(intArrayOf(3, 2, 4, 3), 4, 2).joinToString(","))
    println(Problem2028().missingRolls(intArrayOf(1, 5, 6), 3, 4).joinToString(","))
    println(Problem2028().missingRolls(intArrayOf(1, 2, 3, 4), 6, 4).joinToString(","))
    println(Problem2028().missingRolls(intArrayOf(1), 3, 1).joinToString(","))
    println(
        Problem2028().missingRolls(
            intArrayOf(
                4,
                5,
                6,
                2,
                3,
                6,
                5,
                4,
                6,
                4,
                5,
                1,
                6,
                3,
                1,
                4,
                5,
                5,
                3,
                2,
                3,
                5,
                3,
                2,
                1,
                5,
                4,
                3,
                5,
                1,
                5
            ), 4, 40
        ).joinToString(",")
    )
}