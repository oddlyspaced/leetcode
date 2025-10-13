package old.easy

class Problem2678 {
    fun countSeniors(details: Array<String>): Int {
        var c = 0
        details.forEach {
            println(
                "${
                    it[11].digitToInt()
                }    ${it[12].digitToInt()}"
            )
            if (it[11].digitToInt() > 6 || (it[11].digitToInt() >= 6 && it[12].digitToInt() > 0)) {
                c++
            }
        }
        return c
    }
}

fun main() {
//    println(Problem2678().countSeniors(arrayOf("7868190130M7522", "5303914400F9211", "9273338290F4010")))
    println(
        Problem2678().countSeniors(
            arrayOf(
                "5612624052M0130",
                "5378802576M6424",
                "5447619845F0171",
                "2941701174O9078"
            )
        )
    )
}