package old.easy

class EasyProblem14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        if (strs.size == 1) {
            return strs[0]
        }
        val sm = strs[0]
        var prefix = ""
        for (i in sm.indices) {
            for (str in strs) {
                if (str.length == i || str[i] != sm[i]) {
                    return prefix
                }
            }
            prefix += sm[i]
        }
        return prefix
    }
}

fun main() {
    println(EasyProblem14().longestCommonPrefix(arrayOf("cart", "car")))
}