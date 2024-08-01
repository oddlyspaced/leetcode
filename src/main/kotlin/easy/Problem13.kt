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

        var i = 0
        var res = 0
        while (i < s.length) {
            val c = "${s[i]}"
            var cn = ""
            if ((i + 1) < s.length) {
                cn = s[i + 1].toString()
            }
            if (data["$c$cn"] != null) {
                res += data["$c$cn"] ?: 0
                i += 2
            }
            else {
                res += data[c] ?: 0
                i++
            }
        }
        return res
    }
}

fun main() {
    println(Problem13().romanToInt("III"))
    println(Problem13().romanToInt("LVIII"))
    println(Problem13().romanToInt("MCMXCIV"))
}