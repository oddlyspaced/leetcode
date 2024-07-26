package easy

class Problem367 {
    fun isPerfectSquare(num: Int): Boolean {
        var l = 1
        var r = num / 2

        while (l <= r) {
            val mid = l + ((r - l) / 2)
            val s = (mid * mid)
            println("MM $mid * $mid = $s")
            if (num == s) {
                return true
            } else if (num > s) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return false
    }
}

fun main() {
    println(Problem367().isPerfectSquare(808201))
}