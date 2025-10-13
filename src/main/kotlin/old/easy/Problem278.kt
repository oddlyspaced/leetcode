package old.easy


/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

abstract class VersionControl() {
    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(n: Int): Boolean {
        return (n > 3)
    }
}

class Problem278 : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var l = 1
        var r = n

        while (l <= r) {
            val mid = (l + r) / 2
            if (isBadVersion(mid)) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return l
    }
}

fun main() {
    println(Problem278().firstBadVersion(5))
}