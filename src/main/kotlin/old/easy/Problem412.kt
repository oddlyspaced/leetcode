package old.easy

class Problem412 {
    fun fizzBuzz(n: Int): List<String> {
        return List(n) { index ->
            val fizz = ((index + 1) % 3) == 0
            val buzz = ((index + 1) % 5) == 0
            val fizzBuzz = fizz and buzz
            if (fizzBuzz) {
                "FizzBuzz"
            }
            else if (fizz) {
                "Fizz"
            }
            else if (buzz) {
                "Buzz"
            }
            else {
                (index + 1).toString()
            }
        }
    }
}

fun main() {
    println(Problem412().fizzBuzz(3))
}