package easy

class Problem1539 {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var k = k
        var curr = 1
        var index = 0
        while (k > 0) {
            if (index < arr.size && arr[index] == curr) {
                index++
            } else {
                k--
            }
            curr++
        }
        return curr - 1
    }
}

fun main() {
    println(Problem1539().findKthPositive(intArrayOf(2, 3, 4, 7, 11), 5))
    println(Problem1539().findKthPositive(intArrayOf(1, 2, 3, 4), 2))
}