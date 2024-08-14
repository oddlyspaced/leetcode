package easy

class Problem1431 {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        var max = candies[0]
        for (i in 1..<candies.size) {
            if (max < candies[i]) {
                max = candies[i]
            }
        }
        val res = arrayListOf<Boolean>()
        candies.forEach { i ->
            res.add(i + extraCandies >= max)
        }
        return res
    }
}

fun main() {
    println(Problem1431().kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3).joinToString(","))
}