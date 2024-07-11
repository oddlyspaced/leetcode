package hard

import kotlin.math.min

class Problem4 {
    fun findMedian(arr: IntArray): Double {
        return if (arr.size % 2 == 1) {
            arr[arr.size / 2].toDouble();
        } else {
            ((arr[arr.size / 2] + arr[(arr.size / 2) - 1]) / 2).toDouble()
        }
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val mergedArr = arrayOfNulls<Int>(nums1.size + nums2.size)
        var index = 0
        var index1 = 0
        var index2 = 0
        while (index < mergedArr.size) {
            if (index1 >= nums1.size) {
                while (index2 < nums2.size) {
                    mergedArr[index++] = nums2[index2++]
                }
            } else if (index2 >= nums2.size) {
                while (index1 < nums1.size) {
                    mergedArr[index++] = nums1[index1++]
                }
            }
            else if (nums1[index1] < nums2[index2]) {
                if (nums1[index1] < nums2[index2]) {
                    mergedArr[index++] = nums1[index1++]
                } else {
                    mergedArr[index++] = nums2[index2++]
                }
            }
            println("INDEX : $index")
        }
        println("MERGED : ${mergedArr.joinToString(",")}")
        return 2.0
    }
}

fun main() {
    Problem4().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2, 4))
}