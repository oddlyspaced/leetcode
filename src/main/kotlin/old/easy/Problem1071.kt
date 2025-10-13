package old.easy

class Problem1071 {

    // checks if a string full is made of str
    private fun repeats(str1: String, str2: String, str: String): Boolean {
        if (str1.length % str.length != 0 || str2.length % str.length != 0) {
            return false
        } else {
            for (i in str1.indices) {
                if (str1[i] != str[i % str.length] || str2[i % str2.length] != str[i % str.length]) {
                    return false
                }
            }
        }
        return true
    }

    fun gcdOfStrings(str1: String, str2: String): String {
        val sb = StringBuilder()
        var cur = 0
        var max = ""
        sb.append(str2[cur++])
        while (true) {
            if (repeats(str1, str2, sb.toString())) {
                max = sb.toString()
            }
            if (cur == str2.length) {
                break
            }
            sb.append(str2[cur++])
        }
        return max
    }
}

fun main() {
    println(Problem1071().gcdOfStrings("ABCABC", "ABC"))
    println(Problem1071().gcdOfStrings("ABCABC", "ABDABD"))
    println(Problem1071().gcdOfStrings("ABABAB", "ABAB"))
    println(Problem1071().gcdOfStrings("LEET", "CODE"))
    println(Problem1071().gcdOfStrings("ABABABAB", "ABAB"))
}