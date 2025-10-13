package old.easy

import kotlin.math.abs

class Problem1502 {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        if (arr.size <= 2) {
            return true
        }

        repeat(arr.size) { i ->
            println("AT i = $i // ${arr.joinToString(",")}")
            if (i >= 3) {
                if ((arr[i - 1] - arr[i - 2]) != (arr[1] - arr[0])) {
                    return false
                }
            }
            for (j in (i + 1)..<arr.size) {
                if (arr[i] < arr[j]) {
                    val t = arr[i]
                    arr[i] = arr[j]
                    arr[j] = t
                }
            }
        }

//        val diff = arr[1] - arr[0]
//
//        for (i in (0..arr.size - 2)) {
//            if (arr[i + 1] - arr[i] != diff) {
//                return false
//            }
//        }
        return true
    }
}

fun main() {
    println(Problem1502().canMakeArithmeticProgression(intArrayOf(3, 5, 1, 7, 9, 11)))
    println(Problem1502().canMakeArithmeticProgression(intArrayOf(1, 2, 4, 9, 11, 13)))
    println(Problem1502().canMakeArithmeticProgression(intArrayOf(1, 2, 4, 9, 11, 13)))
}