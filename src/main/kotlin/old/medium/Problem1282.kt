package old.medium

class Problem1282 {

    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val groups = HashMap<Int, ArrayList<ArrayList<Int>>>()

        groupSizes.forEachIndexed { index, size ->
            if (groups[size] == null) {
                groups[size] = arrayListOf()
            }
            if (groups[size]!!.isEmpty()) {
                groups[size]!!.add(arrayListOf(index))
            } else {
                if (groups[size]!!.last().size == size) {
                    groups[size]!!.add(arrayListOf(index))
                } else {
                    groups[size]!!.last().add(index)
                }
            }
        }

        val res = arrayListOf<ArrayList<Int>>()
        groups.values.forEach { v ->
            v.forEach {
                res.add(it)
            }
        }

        return res
    }
}

fun main() {
    Problem1282().groupThePeople(intArrayOf(3, 3, 3, 3, 3, 1, 3)).forEach {
        println(it.joinToString(","))
    }
}