package medium

class Problem17 {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return listOf();
        }
        val data = hashMapOf<Int, String>()
        data[2] = "abc"
        data[3] = "def"
        data[4] = "ghi"
        data[5] = "jkl"
        data[6] = "mno"
        data[7] = "pqrs"
        data[8] = "tuv"
        data[9] = "wxyz"

        val strings = arrayListOf<String>()
        digits.forEach {
            strings.add(data[it.digitToInt()]!!)
        }

        val res = arrayListOf<String>()
        gen(strings.toTypedArray(), 0, "", res)
        return res
    }

    fun gen(strs: Array<String>, indexStr: Int, temp: String, data: ArrayList<String>) {
        if (indexStr >= strs.size) {
//            println(temp)
            data.add(temp)
        } else {
            for (i in 0..<strs[indexStr].length) {
                gen(strs, indexStr + 1, temp + strs[indexStr][i], data)
            }
        }
    }

}

fun main() {
    println(Problem17().letterCombinations("23").joinToString(","))
}