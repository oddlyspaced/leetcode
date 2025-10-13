package old.easy

class Problem744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var l = 0
        var r = letters.size - 1
        while (l <= r) {
            val mid = (l + r) / 2
            if (target < letters[mid]) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return if (l == letters.size) {
            letters[0]
        } else {
            letters[l]
        }
    }
}

fun main() {
    println(Problem744().nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'a'))
    println(Problem744().nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'c'))
    println(Problem744().nextGreatestLetter(charArrayOf('x', 'x', 'y', 'y'), 'z'))
    println(Problem744().nextGreatestLetter(charArrayOf('x', 'x', 'x', 'y'), 'x'))
}