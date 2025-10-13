package old.easy

class Problem2053 {
    fun kthDistinct(arr: Array<String>, k: Int): String {
        val data = mutableMapOf<String, Int>()
        arr.forEach {
            data[it] = (data[it] ?: 0) + 1
        }
        var k = k
        data.keys.forEach {
            if (data[it] == 1) {
                k--
            }
            if (k == 0) {
                return it
            }
        }
        return ""
    }
}

fun main() {
    println(Problem2053().kthDistinct(arrayOf("d", "b", "c", "b", "c", "a"), 2))
    println(Problem2053().kthDistinct(arrayOf("aaa", "aa", "a"), 1))
    println(Problem2053().kthDistinct(arrayOf("a", "b", "a"), 3))
}