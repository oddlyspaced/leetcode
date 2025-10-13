package old.medium

class Problem877 {
//
//    fun stone(piles: IntArray, l: Int, r: Int, aliceTurn: Boolean, aliceSum: Int, bobSum: Int): Boolean {
//        if (l == r) {
////            println("ALICE : $aliceSum BOB : $bobSum")
//            return aliceSum > bobSum
//        }
//        if (aliceTurn) {
//            if (stone(piles, l + 1, r, false, aliceSum + piles[l], bobSum)) {
//                return true
//            } else {
//                return stone(piles, l, r - 1, false, aliceSum + piles[r], bobSum)
//            }
//        } else {
//            if (stone(piles, l + 1, r, true, aliceSum, bobSum + piles[l])) {
//                return true
//            } else {
//                return stone(piles, l, r - 1, true, aliceSum, bobSum + piles[r])
//            }
//        }
//    }

    fun stoneGame(piles: IntArray): Boolean {
//        return stone(piles, 0, piles.size - 1, true, 0, 0)

        var bobSum = 0
        var aliceSum = 0

        var l = 0
        var r = piles.size - 1

        var aliceTurn = true

        while (l != r) {
            if (aliceTurn) {
                if (piles[l] > piles[r]) {
                    aliceSum = piles[l]
                    l++
                } else {
                    aliceSum = piles[r]
                    r--
                }
                aliceTurn = false
            } else {
                if (piles[l] < piles[r]) {
                    bobSum = piles[l]
                    l++
                } else {
                    bobSum = piles[r]
                    r--
                }
                aliceTurn = true
            }
        }
        return aliceSum > bobSum
    }
}

fun main() {
    println(Problem877().stoneGame(intArrayOf(5, 3, 4, 5)))
    println(Problem877().stoneGame(intArrayOf(3, 7, 2, 3)))
}