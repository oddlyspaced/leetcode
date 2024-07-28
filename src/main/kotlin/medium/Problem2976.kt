//package medium
//
//class Problem2976 {
//    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
//        // source -> target, cost
//        val costMap = hashMapOf<Char, HashMap<Char, Int>>()
//
//        original.forEachIndexed { index, c ->
//            if (costMap[c] == null) {
//                costMap[c] = hashMapOf()
//            }
//            costMap[c]!![changed[index]] = cost[index]
//        }
//
//        costMap.keys.forEach { a ->
//            costMap[a]?.keys?.forEach { b ->
//                println("$a $b ${costMap[a]!![b]}")
//            }
//        }
//
//        var cost = 0L
//        source.forEachIndexed { index, s ->
//            println("$s -> ${target[index]}")
//        }
//
//        return 0L
//    }
//}
//
//fun main() {
//    println(
//        Problem2976().minimumCost(
//            "abcd", "acbe",
//            charArrayOf('a', 'b', 'c', 'c', 'e', 'd'),
//            charArrayOf('b', 'c', 'b', 'e', 'b', 'e'),
//            intArrayOf(2, 5, 5, 1, 2, 20)
//        )
//    )
//}