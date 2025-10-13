package old.medium

class Problem274 {
    fun hIndex(citations: IntArray): Int {
        var h = 0
        var hCount = 0
        // The h-index is defined as the maximum value of h
        // such that the given researcher has published at
        // least h papers that have each been cited at least h times.
        for (citation in citations) {
            var count = 0
            for (cit in citations) {
                if (cit >= citation) {
                    count++
                }
            }
            println("$count $citation")
            if (count > hCount && h < citation) {
                h = citation
                hCount = count
            }
        }

        return hCount
    }
}

fun main() {
    println(Problem274().hIndex(intArrayOf(3, 0, 6, 1, 5)))
    println(Problem274().hIndex(intArrayOf(1, 3, 1)))
    println(Problem274().hIndex(intArrayOf(100)))
}