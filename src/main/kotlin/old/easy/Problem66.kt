package old.easy

class Problem66 {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.indices) {
            val last = digits.size - 1 - i
            if (digits[last] < 9) {
                digits[last] += 1
                break
            }
            // 9
            else {
                digits[last] = 0
            }
        }
        if (digits[0] == 0) {
            val new = IntArray(digits.size + 1)
            new[0] = 1
            return new
        }
        return digits
    }
}

fun main() {
    println(Problem66().plusOne(intArrayOf(9, 1, 9)).joinToString(""))
}