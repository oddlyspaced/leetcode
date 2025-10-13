package old.medium

class Problem2924 {
    fun findChampion(n: Int, edges: Array<IntArray>): Int {
        val incoming = IntArray(n)
        edges.forEach {
            incoming[it[1]]++
        }
        val champions = mutableListOf<Int>()
        incoming.forEachIndexed { index, i ->
            if (i == 0) {
                champions.add(index)
            }
        }
        return if (champions.size > 1) -1 else champions.first()
    }
}