package old.medium

class Problem12 {
    fun intToRoman(num: Int): String {
        val nums = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val roms = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

        var num = num
        var res = ""

        var index = 0
        while (num > 0) {
            val check = nums[index]
            val rem = num / check
            if (rem == 0) {
                index++
                continue
            }
            repeat(rem) {
                res += roms[index]
            }
            num %= check
        }

        return res
    }
}

fun main() {
    println(Problem12().intToRoman(1994))
}