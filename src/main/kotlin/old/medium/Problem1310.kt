package old.medium

class Problem1310 {
    fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray {
        val res = IntArray(queries.size)
        queries.forEachIndexed { index, query ->
            for (i in query[0]..query[1]) {
                res[index] = res[index] xor arr[i]
            }
        }
        return res
    }
}

fun main() {
    println(
        Problem1310().xorQueries(
            intArrayOf(1, 3, 4, 8), arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(0, 3),
                intArrayOf(3, 3)
            )
        ).joinToString(",")
    )
}