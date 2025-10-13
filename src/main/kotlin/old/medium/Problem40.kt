package old.medium

class Problem40 {
    private fun combination(
        candidates: IntArray,
        target: Int,
        curIndex: Int,
        curTarget: Int,
        curValues: String,
    ) {
        if (curIndex == candidates.size) {
            return
        }
        println("V : $curValues")
        var curIndex = curIndex
        curIndex++
        while (curIndex < candidates.size) {
            combination(candidates, target, curIndex, 0, curValues + candidates[curIndex])
            curIndex++
        }
    }

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        combination(candidates, target, 0, 0, "1")
        return listOf()
    }
}

fun main() {
    Problem40().combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8).forEach {
        println(it.joinToString(","))
    }
}