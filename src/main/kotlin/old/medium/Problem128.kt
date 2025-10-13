package old.medium

class Problem128 {
    fun longestConsecutive(nums: IntArray): Int {
        val set = HashSet<Int>()
        nums.forEach {
            set.add(it)
        }

        var long = 0
        for (v in set) {
            // check if left exists
            if (!set.contains(v - 1)) {
                println("STARTING FOR $v")
                var cur = v
                var seq = 1
                // find conseq
                while (set.contains(cur + 1)) {
                    cur++
                    seq++
                }
                if (seq > long) {
                    long = seq
                }
            }
        }
        return long
    }
}

fun main() {
    println(Problem128().longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
}