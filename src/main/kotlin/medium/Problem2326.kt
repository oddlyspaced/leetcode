package medium

import easy.ListNode

class Problem2326 {
    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        val res = Array(m) {
            IntArray(n) {
                -1
            }
        }

        var copy = head

        var top = 0
        var left = 0
        var bottom = res.size - 1
        var right = res[0].size - 1
        var dir = 0
        while (top <= bottom && left <= right && copy != null) {
            when (dir) {
                0 -> {
                    for (i in left until right + 1) {
                        if (copy == null) {
                            break
                        }
                        res[left][i] = copy.`val`
                        copy = copy.next
                    }
                    top++
                }

                1 -> {
                    for (i in top until bottom + 1) {
                        if (copy == null) {
                            break
                        }
                        res[i][right] = copy.`val`
                        copy = copy.next
                    }
                    right--
                }

                2 -> {
                    for (i in right downTo left) {
                        if (copy == null) {
                            break
                        }
                        res[bottom][i] = copy.`val`
                        copy = copy.next
                    }
                    bottom--
                }

                3 -> {
                    for (i in bottom downTo top) {
                        if (copy == null) {
                            break
                        }
                        res[i][left] = copy.`val`
                        copy = copy.next
                    }
                    left++
                }
            }
            dir = (dir + 1) % 4
        }

        return res
    }
}

fun main() {
    val values = intArrayOf(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0)
    val head = ListNode(values[0])
    var headCopy: ListNode? = head

    for (i in 1..<values.size) {
        headCopy?.next = ListNode(values[i])
        headCopy = headCopy?.next
    }

    Problem2326().spiralMatrix(3, 5, head).forEach {
        println(it.joinToString("\t"))
    }
}