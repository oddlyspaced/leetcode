package medium

class Problem40 {

    private val res = arrayListOf<List<Int>>()
    private fun combination(
        candidates: IntArray,
        target: Int,
        curIndex: Int,
        curTarget: Int,
        curValues: List<Int>,
    ) {
        if (curTarget == target) {
            res.add(curValues.toMutableList())
            return
        } else if (curTarget > target || curIndex == candidates.size) {
            return
        }
        val t = curValues.toMutableList()
        t.addLast(candidates[curIndex])
        combination(candidates, target, curIndex + 1, curTarget + candidates[curIndex], t)
        t.removeLast()
        // skip
        var curIndex = curIndex
        while ((curIndex + 1) < candidates.size && candidates[curIndex] == candidates[curIndex + 1]) {
            curIndex++
        }
        combination(candidates, target, curIndex + 1, curTarget, t)
    }

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        combination(candidates, target, 0, 0, listOf())
        return res
    }
}

fun main() {
    Problem40().combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8).forEach {
        println(it.joinToString(","))
    }
    println("---")
    Problem40().combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5).forEach {
        println(it.joinToString(","))
    }
}