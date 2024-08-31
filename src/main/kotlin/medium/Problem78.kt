package medium

class Problem78 {
    fun gen(index: Int, cur: String, data: IntArray) {
        if (index == data.size) {
            return
        }
        println("$cur${data[index]}")
        for (i in data.indices) {
            gen(i, "$cur${data[i]}", data)
        }
    }

    fun subsets(nums: IntArray): List<List<Int>> {
        gen(0, "", nums)
        return listOf()
    }
}

fun main() {
    Problem78().subsets(intArrayOf(1, 2, 3)).forEach {
        println(it.joinToString(","))
    }
}

/*
1
1 2
1 3

2
3


 */