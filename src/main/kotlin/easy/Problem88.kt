package easy

class Problem88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i1 = m - 1
        var i2 = n - 1
        var i = m + n - 1

        while (i1 > -1 || i2 > -1) {
            if (i1 > -1 && i2 > -1) {
                if (nums1[i1] > nums2[i2]) {
                    nums1[i--] = nums1[i1--]
                } else {
                    nums1[i--] = nums2[i2--]
                }
            } else if (i1 > -1) {
                nums1[i--] = nums1[i1--]
            } else if (i2 > -1) {
                nums1[i--] = nums2[i2--]
            }
        }
        println(nums1.joinToString(" "))
    }


}

fun main() {
    println(Problem88().merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3))
}