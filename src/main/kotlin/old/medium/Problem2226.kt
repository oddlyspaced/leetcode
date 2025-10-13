package old.medium

class Problem2226 {
    fun maximumCandies(candies: IntArray, k: Long): Int {
        var res = 0
        var left = 1
        var right = 10_000_000
        while (left <= right) {
            val mid = (left + right) / 2
            var child = 0L
            for (candy in candies) {
                child += candy / mid
            }
            if (child >= k) {
                res = mid
                left = mid + 1
            }
            else {
                right = mid - 1
            }
        }
        return res
    }
}

