package medium

class Problem1817 {
    fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
        val activity = hashMapOf<Int, HashSet<Int>>()
        logs.forEach { log ->
            if (activity[log[0]] == null) {
                activity[log[0]] = hashSetOf()
            }
            activity[log[0]]!!.add(log[1])
        }
        val res = IntArray(k)
        activity.values.forEach {
            if (it.size < k) {
                res[it.size - 1]++
            }
        }
        return res
    }
}

fun main() {
    println(
        Problem1817().findingUsersActiveMinutes(
            arrayOf(
                intArrayOf(0, 5),
                intArrayOf(1, 2),
                intArrayOf(0, 2),
                intArrayOf(0, 5),
                intArrayOf(1, 3)
            ), 5
        ).joinToString(",")
    )

    println(
        Problem1817().findingUsersActiveMinutes(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(2, 3),
            ), 4
        ).joinToString(",")
    )
}