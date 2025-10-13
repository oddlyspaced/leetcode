package old.medium

class Problem670 {
    fun maximumSwap(num: Int): Int {
        val digs = arrayListOf<Int>()
        var copy = num
        while (copy > 0) {
            digs.add(copy % 10)
            copy /= 10
        }
        digs.reverse()
        var startIndex = 0
        while (startIndex < digs.size - 1) {
            var maxIndex = startIndex
            for (index in startIndex..<digs.size) {
                if (digs[index] >= digs[maxIndex]) {
                    maxIndex = index
                }
            }
            if (startIndex != maxIndex && digs[startIndex] < digs[maxIndex]) {
                val t = digs[startIndex]
                digs[startIndex] = digs[maxIndex]
                digs[maxIndex] = t
                return digs.joinToString("").toInt()
            }
            startIndex++
        }
        return digs.joinToString("").toInt()
    }
}

fun main() {
    println(Problem670().maximumSwap(2736))
//    println(Problem670().maximumSwap(9973))
//    println(Problem670().maximumSwap(1100))
//    println(Problem670().maximumSwap(2310))
//    println(Problem670().maximumSwap(9948))
}