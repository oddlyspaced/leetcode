package easy

class Problem13 {
    fun romanToInt(s: String): Int {
        val data = hashMapOf<String, Int>()
        data["I"] = 1
        data["IV"] = 4
        data["V"] = 5
        data["IX"] = 9
        data["X"] = 10
        data["XL"] = 40
        data["L"] = 50
        data["XC"] = 90
        data["C"] = 100
        data["CD"] = 400
        data["D"] = 500
        data["CM"] = 900
        data["M"] = 1000
        var res = 0
        var index = 0
        while (index < s.length) {
            val c = s[index].toString()
            var cn = c
            if (index + 1 < s.length) {
                cn = s[index + 1].toString()
            }
            // if next is greater than use both
            if (data[cn]!! > data[c]!!) {
                res += data[c + cn]!!
                index += 2
            } else {
                res += data[c]!!
                index++
            }
        }
        return res
    }
}

fun main() {
    println(Problem13().romanToInt("MCMXCIV"))
}