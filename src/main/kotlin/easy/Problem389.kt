package easy

class Problem389 {
    fun findTheDifference(s: String, t: String): Char {
        val data = hashMapOf<Char, Int>()
        t.forEach {
            data[it] = (data[it] ?: 0) + 1

        }
        s.forEach {
            data[it] = data[it]!! - 1
        }
        data.keys.forEach {
            if (data[it]!! > 0) {
                return it
            }
        }
        return ' '
    }
}

fun main() {
    println(Problem389().findTheDifference("a", "aa"))
}