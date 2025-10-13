package old.easy

class Problem1518 {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var res = 0
        var numBottles = numBottles

        var total = numBottles
        var filled = numBottles
        var empty = 0

        while (total > numExchange) {
            println("TOTAL $total FILLED $filled EMPTY $empty")
            res += filled
            empty += filled
            filled /= numExchange
            empty %= numExchange

            total = filled + empty
        }
        println("$total $filled $empty")
        return res
    }
}

fun main() {
    println(Problem1518().numWaterBottles(9, 3))
    println()
    println(Problem1518().numWaterBottles(15, 4))
    println()
    println(Problem1518().numWaterBottles(15, 8))
}