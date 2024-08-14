package easy

class Problem605 {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (flowerbed.size > 3) {
            // find first occurrence of 1
            var indexOf1 = -1
            for (i in flowerbed.indices) {
                if (flowerbed[i] == 1) {
                    indexOf1 = i
                    break
                }
            }

            for (i in indexOf1..<flowerbed.size) {

            }
        }
        return true
    }
}

fun main() {
    println(Problem605().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
}