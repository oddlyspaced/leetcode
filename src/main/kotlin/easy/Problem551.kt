package easy

class Problem551 {
    fun checkRecord(s: String): Boolean {
        var absent = 0
        var wasLate = false
        var late = 0
        s.forEach {
            if (it == 'A') {
                absent++
            }
            if (it == 'L') {
                late++
            }
            if (late == 3) {
                wasLate = true
            }
            if (it != 'L') {
                late = 0
            }
        }
        return absent < 2 && !wasLate
    }
}

fun main() {
    println(Problem551().checkRecord("PPALLL"))
}