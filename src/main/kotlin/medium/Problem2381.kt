package medium

class Problem2381 {
    private fun rotateLetter(letter: Char, direction: Int): Char {
        return if (direction == 0) { // backwards
            if (letter == 'a') {
                'z'
            } else {
                letter - 1
            }
        } else { // forward
            if (letter == 'z') {
                'a'
            } else {
                letter + 1
            }
        }
    }

    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val str = StringBuilder(s)
        shifts.forEach { shift ->
            for (i in shift[0]..shift[1]) {
                str[i] = rotateLetter(str[i], shift[2])
            }
        }
        return str.toString()
    }
}

fun main() {
    println(
        Problem2381().shiftingLetters(
            "abc",
            arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 2, 1), intArrayOf(0, 2, 1))
        )
    )
}