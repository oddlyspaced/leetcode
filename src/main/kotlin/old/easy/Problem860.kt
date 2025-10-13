package old.easy

class Problem860 {
    fun lemonadeChange(bills: IntArray): Boolean {
        var count5 = 0
        var count10 = 0

        for (bill in bills) {
            when (bill) {
                5 -> count5++
                10 -> count10++
            }
            if (bill > 5) {
                // need to give change
                var change = bill - 5
                while (change > 0) {
                    if (change >= 10 && count10 > 0) {
                        count10--
                        change -= 10
                    } else if (change >= 5 && count5 > 0) {
                        count5--
                        change -= 5
                    } else {
                        return false
                    }
                }
            }
        }
        return true
    }
}

fun main() {
    println(Problem860().lemonadeChange(intArrayOf(5, 5, 5, 10, 20)))
    println(Problem860().lemonadeChange(intArrayOf(5, 5, 10, 10, 20)))
}