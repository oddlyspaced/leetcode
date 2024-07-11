package easy

class Problem121 {
    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var minIndex = 0
        var profit = 0

        for (i in prices.indices) {
            if (prices[i] - prices[minIndex] > profit) {
                profit = prices[i] - prices[minIndex]
            }
            if (prices[i] < min) {
                min = prices[i]
                minIndex = i
            }
        }
        return profit
    }
}

fun main() {
    println(Problem121().maxProfit(intArrayOf(2, 4, 1)))
    println(Problem121().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    println(Problem121().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}