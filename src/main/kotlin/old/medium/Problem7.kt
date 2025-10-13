package old.medium


class Problem7 {
    fun reverse(x: Int): Int {
        return try {
            if (x > 0) {
                x.toString().reversed().toInt()
            } else {
                "-${(x * -1).toString().reversed()}".toInt()
            }
        } catch (e: Exception) {
            0
        }
    }
}

fun main() {
    println(Problem7().reverse(1534236469))
}