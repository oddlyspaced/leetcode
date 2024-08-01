package medium

class Problem275 {
    fun hIndex(citations: IntArray): Int {
        var l = 0
        var r = citations.size - 1
        val size = citations.size
        var h = 0

        // quality <= quantity

        while (l <= r) {
            val mid = (l + r) / 2
            val quality = citations[mid]
            val quantity = size - mid

            if (quality == quantity) {
                return quality
            }
            else if (quality > quantity) {
                if (quantity > h) {
                    h = quantity
                }
                r = mid - 1
            } else {
                if (quality > h) {
                    h = quality
                }
                l = mid + 1
            }
        }

//
//        val len = citations.size
//        var left = 0
//        var right = len-1
//        var max_h = 0
//        while (right >= left) {
//            val mid = (left + right) / 2
//            val cit = citations[mid]
//            val c_h = len - mid
////				println("left=$left,mid=$mid,right=$right,cit=$cit,c_h=$c_h,max_h=$max_h")
//            if (cit==c_h) return cit
//            if (cit>c_h) {
//                max_h	= maxOf(max_h,c_h)
//                right = mid - 1
//            } else {
//                max_h	= maxOf(max_h,cit)
//                left = mid + 1
//            }
//        }
//        return max_h
//
//        var max = 0
//        for (i in citations.indices) {
//            val quality = citations[i]
//            val quantity = citations.size - i
//            if (quality <= quantity) {
//                max = quantity
//            }
//        }
        return h
    }
}

fun main() {
    println(Problem275().hIndex(intArrayOf(0, 1, 3, 5, 6)))
    println(Problem275().hIndex(intArrayOf(1, 2, 100)))
    println(Problem275().hIndex(intArrayOf(0)))
    println(Problem275().hIndex(intArrayOf(0, 0)))
    println(Problem275().hIndex(intArrayOf(100)))
}