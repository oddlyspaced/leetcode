package old.easy

class Problem605 {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0) {
            return true
        } else if (flowerbed.size == 1) {
            return (flowerbed[0] == 0 && n == 1)
        }
        var index = 0
        var n = n
        while (index < flowerbed.size && n > 0) {
            if (flowerbed[index] == 0) {
                val prev = index - 1
                val next = index + 1
                if ((prev >= 0 && flowerbed[prev] == 0) && (next < flowerbed.size && flowerbed[next] == 0)) {
                    flowerbed[index] = 1
                    n--
                } else if (index == 0 && flowerbed[next] == 0) {
                    flowerbed[index] = 1
                    n--
                } else if (index == flowerbed.size - 1 && flowerbed[prev] == 0) {
                    flowerbed[index] = 1
                    n--
                }
            }
            index++
        }
        return n == 0
    }
}

fun main() {
    println(Problem605().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
    println(Problem605().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2))
    println(Problem605().canPlaceFlowers(intArrayOf(0, 0), 1))
    println(Problem605().canPlaceFlowers(intArrayOf(1, 0, 0, 0, 0, 1), 2))
    println(Problem605().canPlaceFlowers(intArrayOf(0, 0), 2))

}