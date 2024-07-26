package medium

class Problem2191 {

    private fun convertNum(mapping: IntArray, num: Int): Int {
        val n = StringBuilder()
        (num.toString()).forEach {
            n.append(mapping[it.digitToInt()])
        }
        return n.toString().toInt()
    }

    fun sortJumbled(mapping: IntArray, nums: IntArray): IntArray {
        val mappedNums = hashMapOf<Int, ArrayList<Int>>()
        nums.forEach {
            val conv = convertNum(mapping, it)
            if (mappedNums[conv] == null) {
                mappedNums[conv] = arrayListOf()
            }
            mappedNums[conv]?.add(it)
        }

        val sorted = mappedNums.keys.sorted()
        val res = arrayListOf<Int>()

        sorted.forEach {
            mappedNums[it]?.forEach { n ->
                res.add(n)
            }
        }
        return res.toIntArray()
    }
}

fun main() {
    println(
        Problem2191().sortJumbled(intArrayOf(8, 9, 4, 0, 2, 1, 3, 5, 7, 6), intArrayOf(991, 338, 38)).joinToString(",")
    )
}