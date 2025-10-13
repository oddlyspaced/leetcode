package old.easy

class Problem118 {
    fun generate(numRows: Int): List<List<Int>> {
        when (numRows) {
            0 -> {
                return listOf()
            }

            1 -> {
                return listOf(listOf(1))
            }

            2 -> {
                return listOf(listOf(1), listOf(1, 1))
            }

            else -> {
                val triangle = arrayListOf(arrayListOf(1), arrayListOf(1, 1))
                for (i in 2..<numRows) {
                    val prev = triangle[i - 1]
                    val data = arrayListOf(1)
                    for (j in 1..<i) {
                        data.add(prev[j] + prev[j - 1])
                    }
                    data.add(1)
                    triangle.add(data)
                }
                return triangle
            }
        }
    }
}

fun main() {
    Problem118().generate(10).forEach {
        println(it.joinToString("\t"))
    }
}