//package medium
//
//class Problem46 {
//    fun permute(nums: IntArray): List<List<Int>> {
//        gen(nums, arrayListOf())
//        return data
//    }
//
//    private fun gen(nums: IntArray, temp: ArrayList<Int>, data: ArrayList<List<Int>>) {
//        if (temp.size == nums.size) {
//            data.add(temp)
//        } else {
//            nums.forEach {
//                if (!temp.contains(it)) {
//                    temp.add(it)
//                    gen(nums, temp, data)
//                }
//            }
//        }
//    }
//}
//
//fun main() {
////    Problem46().gen(intArrayOf(1, 2, 3), hashSetOf())
//    Problem46().permute(intArrayOf(1, 2, 3)).forEach {
//        println(it.joinToString(","))
//    }
//}