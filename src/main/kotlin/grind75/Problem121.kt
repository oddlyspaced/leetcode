package grind75

/**
 * Created by Hardik Srivastava on 15/10/25
 */
class Problem121 {
    fun maxProfit(prices: IntArray): Int {
        var l = 0
        var r = 1
        var m = 0
        while (r < prices.size) {
            if (prices[l] < prices[r]) {
                m = maxOf(m, prices[r] - prices[l])
            } else {
                l = r
            }
            r++
        }
        return m
    }
}

fun main() {
    println(Problem121().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(Problem121().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    println(Problem121().maxProfit(intArrayOf(2, 1, 4)))

}