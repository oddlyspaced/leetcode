package medium

class Problem1545 {


    private fun invert(str: String): String {
        return str.replace("1", "X").replace("0", "1").replace("X", "0")
    }

    private fun reverse(str: String) = str.reversed()

    private fun gen(prev: String): String {
        return prev + "1" + reverse(invert(prev))
    }

    fun findKthBit(n: Int, k: Int): Char {
        var res = "0"
        repeat(n) {
            res = gen(res)
        }
        return res[k - 1]
    }
}

fun main() {
    println(Problem1545().findKthBit(3, 1))
}