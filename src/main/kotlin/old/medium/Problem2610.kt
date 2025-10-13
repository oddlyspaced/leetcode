package old.medium

class Problem2610 {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val all = ArrayList<Int>()
        val nodups = hashSetOf<Int>()
        nums.forEach { all.add(it) }
        val res = arrayListOf<List<Int>>()
        while (all.isNotEmpty()) {
            val t = arrayListOf<Int>()
            all.forEach {
                nodups.add(it)
            }
            nodups.forEach {
                t.add(it)
                all.remove(it)
            }
            nodups.clear()
            res.add(t)
        }
        return res
    }
}

fun main() {
    Problem2610().findMatrix(intArrayOf(1, 3, 4, 1, 2, 3, 1)).forEach {
        println(it.joinToString(","))
    }
}