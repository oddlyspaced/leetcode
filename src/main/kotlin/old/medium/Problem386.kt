package old.medium

import java.util.PriorityQueue

class Problem386 {
    fun lexicalOrder(n: Int): List<Int> {
        val pq = PriorityQueue { n1: Int, n2: Int ->
            n1.toString().compareTo(n2.toString())
        }
        for (i in 1..n) {
            pq.add(i)
        }
        val res = arrayListOf<Int>()
        while (pq.isNotEmpty()) {
            res.add(pq.poll())
        }
        return res
    }
}

fun main() {
    println(Problem386().lexicalOrder(13).joinToString(","))
}