package easy

class Problem1460 {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
//        val v1 = hashMapOf<Int, Int>()
//        val v2 = hashMapOf<Int, Int>()
//
//        for (i in target.indices) {
//            v1[target[i]] = (v1[target[i]] ?: 0) + 1
//            v2[arr[i]] = (v2[arr[i]] ?: 0) + 1
//        }
//
//        v2.keys.forEach {
//            if (v1[it] != v2[it]) {
//                return false
//            }
//        }
//        return true

        val data = hashMapOf<Int, Int>()

        for (i in target.indices) {
            data[target[i]] = (data[target[i]] ?: 0) + 1
            data[arr[i]] = (data[arr[i]] ?: 0) - 1
        }

        data.values.forEach {
            if (it != 0) {
                return false
            }
        }
        return true
    }
}

fun main() {
    println(Problem1460().canBeEqual(intArrayOf(1, 2, 3, 4), intArrayOf(2, 4, 1, 3)))
}