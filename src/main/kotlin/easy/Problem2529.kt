package easy

class Problem2529 {
    fun maximumCount(nums: IntArray): Int {
        var pos = 0
        var neg = 0
        nums.forEach {
            if (it > 0) {
                pos++
            }
            else if (it < 0) {
                neg++
            }
        }
        return maxOf(pos, neg)
    }
}

fun main() {
    println(Problem2529().maximumCount(intArrayOf(-2,-1,-1,1,2,3)))
}