package hard

import kotlin.math.min

class Problem8 {
    fun largestRectangleArea(heights: IntArray): Int {
        var area = 0
        for (left in heights.indices) {
            var min = heights[left]
            for (right in (left)..<heights.size) {
                // find min
                if (heights[right] < min) {
                    min = heights[right]
                }
                val temp = (right - left + 1) * min
                if (temp > area) {
                    area = temp
                }
            }
        }
        return area

    }
}

fun main() {
    println(Problem8().largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
    println(Problem8().largestRectangleArea(intArrayOf(2, 4)))
    println(Problem8().largestRectangleArea(intArrayOf(1, 1)))
    println(Problem8().largestRectangleArea(intArrayOf(0, 9)))

}