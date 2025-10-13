package old.hard

class Problem273 {

    private fun dig2Str(n: Int): String {
        return when (n) {
            1 -> "One"
            2 -> "Two"
            3 -> "Three"
            4 -> "Four"
            5 -> "Five"
            6 -> "Six"
            7 -> "Seven"
            8 -> "Eight"
            9 -> "Nine"
            10 -> "Ten"
            11 -> "Eleven"
            12 -> "Twelve"
            13 -> "Thirteen"
            14 -> "Fourteen"
            15 -> "Fifteen"
            16 -> "Sixteen"
            17 -> "Seventeen"
            18 -> "Eighteen"
            19 -> "Nineteen"
            20 -> {
                return "Twenty"
            }

            in 21..29 -> {
                return "Twenty ${dig2Str(n % 10)}"
            }

            30 -> {
                return "Thirty"
            }

            in 31..39 -> {
                return "Thirty ${dig2Str(n % 10)}"
            }

            40 -> {
                return "Forty"
            }

            in 41..49 -> {
                return "Forty ${dig2Str(n % 10)}"
            }

            50 -> {
                return "Fifty"
            }

            in 51..59 -> {
                return "Fifty ${dig2Str(n % 10)}"
            }

            60 -> {
                return "Sixty"
            }

            in 61..69 -> {
                return "Sixty ${dig2Str(n % 10)}"
            }

            70 -> {
                return "Seventy"
            }

            in 71..79 -> {
                return "Seventy ${dig2Str(n % 10)}"
            }

            80 -> {
                return "Eighty"
            }

            in 81..89 -> {
                return "Eighty ${dig2Str(n % 10)}"
            }

            90 -> {
                return "Ninety"
            }

            in 91..99 -> {
                return "Ninety ${dig2Str(n % 10)}"
            }

            else -> {
                if (n > 99) {
                    val hundredth = n / HUNDRED
                    val remaining = n % HUNDRED
                    var res = dig2Str(hundredth) + " Hundred"
                    if (remaining > 0) {
                        res += " " + dig2Str(remaining)
                    }
                    return res
                } else {
                    return ""
                }
            }
        }
    }

    private companion object {
        const val BILLION = 1_000_000_000
        const val MILLION = 1_000_000
        const val THOUSAND = 1_000
        const val HUNDRED = 1_00
    }

    fun numberToWords(num: Int): String {
        if (num == 0) {
            return "Zero"
        }
        var n = num
        val res = StringBuilder()

        // billion
        val billionth = n / BILLION
        if (billionth > 0) {
            res.append(dig2Str(billionth)).append(" Billion ")
        }
        n %= BILLION
        // million
        val millionth = n / MILLION
        if (millionth > 0) {
            res.append(dig2Str(millionth)).append(" Million ")
        }
        n %= MILLION
        // thousand
        val thousandth = n / THOUSAND
        if (thousandth > 0) {
            res.append(dig2Str(thousandth)).append(" Thousand ")
        }
        n %= THOUSAND
        res.append(dig2Str(n))
        return res.toString().trim()
    }
}

fun main() {
    println(Problem273().numberToWords(0))
    println(Problem273().numberToWords(1))
    println(Problem273().numberToWords(16))
    println(Problem273().numberToWords(123))
    println(Problem273().numberToWords(12345))
    println(Problem273().numberToWords(1234567))
    println(Problem273().numberToWords(1234567891))
}