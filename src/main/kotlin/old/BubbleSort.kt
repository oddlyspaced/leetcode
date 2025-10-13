package old

class BubbleSort {
    fun sort(values: IntArray) {
        for (i in 0..2) {
            for (j in i..<values.size) {
                if (values[i] > values[j]) {
                    values[i] = values[i] + values[j]
                    values[j] = values[i] - values[j]
                    values[i] = values[i] - values[j]
                }
            }
        }
        println(values.joinToString(","))
    }
}

fun main() {
    BubbleSort().sort(intArrayOf(5, 3, 9, 1, 6, 0))
}