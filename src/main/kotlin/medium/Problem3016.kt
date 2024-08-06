package medium

class Problem3016 {
    fun minimumPushes(word: String): Int {
        val count = hashMapOf<Char, Int>()
        word.forEach {
            count[it] = (count[it] ?: 0) + 1
        }
        var limit = 1
        var sum = 0
        count.toList().sortedBy { (_, value) -> value }.reversed().forEachIndexed { index, pair ->
            sum += (pair.second * limit)
            if ((index + 1) % 8 == 0) {
                limit++
            }
        }

        return sum
    }
}

fun main() {
//    println(Problem3016().minimumPushes("abcde"))
//    println(Problem3016().minimumPushes("xyzxyzxyzxyz"))
//    println(Problem3016().minimumPushes("aabbccddeeffgghhiiiiii"))
    println(Problem3016().minimumPushes("abzaqsqcyrbzsrvamylmyxdjl"))
}