package medium

class Problem2491 {
    fun dividePlayers(skill: IntArray): Long {
        val total = skill.sum()

        if ((total * 2) % skill.size != 0) {
            return -1
        }

        val count = hashMapOf<Int, Int>()
        skill.forEach {
            count[it] = (count[it] ?: 0) + 1
        }

        val target = (total * 2) / skill.size
        var res = 0L

        for (s in skill) {
            if (count.getOrDefault(s, 0) == 0) {
                continue
            }
            val diff = target - s
            if (count.getOrDefault(diff, 0) == 0) {
                return -1
            }
            res += s * diff
            count[s] = (count[s] ?: 0) - 1
            count[diff] = (count[diff] ?: 0) - 1
        }

        return res
    }
}

fun main() {
    println(Problem2491().dividePlayers(intArrayOf(3, 2, 5, 1, 3, 4)))
    println(Problem2491().dividePlayers(intArrayOf(3, 4)))
    println(Problem2491().dividePlayers(intArrayOf(1, 1, 2, 3)))
    println(Problem2491().dividePlayers(intArrayOf(2, 2, 2, 2)))
}