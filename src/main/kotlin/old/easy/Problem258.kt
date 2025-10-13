package old.easy

class Problem258 {
    fun addDigits(num: Int): Int {
        var num = num
        while (num > 9) {
            var sum = 0
            var copy = num
            while (copy > 0) {
                sum += (copy % 10)
                copy /= 10
            }
            num = sum
        }
        return num
    }
}

fun main() {
    println(Problem258().addDigits(38))
}