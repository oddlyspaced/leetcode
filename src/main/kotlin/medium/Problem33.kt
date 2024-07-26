package medium

class Problem33 {
    fun search(nums: IntArray, target: Int): Int {
        var res = nums[0]
        var pivot = 0
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            // all sorted ascending
            if (nums[l] < nums[r]) {
                if (res > nums[l]) {
                    res = nums[l]
                    pivot = l
                }
            }
            val mid = (l + r) / 2
            if (res > nums[mid]) {
                res = nums[mid]
                pivot = mid
            }

            if (nums[mid] >= nums[l]) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        // we found pivot, thus now we need to search in either left of it or right of it
        if (target > nums[nums.size - 1]) {
            // value will be between 0 and pivot
            l = 0
            r = pivot - 1
        } else {
            l = pivot
            r = nums.size - 1
        }

        while (l <= r) {
            val mid = (l + r) / 2
            if (nums[mid] == target) {
                return mid
            } else if (target > nums[mid]) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return -1
    }

}

fun main() {
    println(Problem33().search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
}


//
//
//fun search(nums: IntArray, target: Int): Int {
//    var res = nums[0]
//    var pivot = 0
//    var l = 0
//    var r = nums.size - 1
//
//    while (l <= r) {
//        // all sorted ascending
//        if (nums[l] < nums[r]) {
//            if (res > nums[l]) {
//                res = nums[l]
//                pivot = l
//            }
//        }
//        val mid = (l + r) / 2
//        if (res > nums[mid]) {
//            res = nums[mid]
//            pivot = mid
//        }
//
//        if (nums[mid] >= nums[l]) {
//            l = mid + 1
//        }
//        else {
//            r = mid - 1
//        }
//    }
//    println("$res $pivot")
//
//    // we found pivot, thus now we need to search in either left of it or right of it
//
//
//    return res
//}