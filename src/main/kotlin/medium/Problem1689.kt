package medium

class Problem1689 {
    fun minPartitions(n: String): Int {
        var max = 0
        for (c in n) {
            if (c == '9') {
                return 9
            }
            max = maxOf(max, c - '0')
        }
        return max
    }
}

fun main() {
    println(Problem1689().minPartitions("32"))
    println(Problem1689().minPartitions("82734"))
    println(Problem1689().minPartitions("27346209830709182346"))
}