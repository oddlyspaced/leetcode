package easy

class EasyProblem9 {
    fun isPalindrome(x: Int): Boolean {
        val s = x.toString()
        return s.reversed() == s
    }
}

fun main() {
    println(EasyProblem9().isPalindrome(121))
}