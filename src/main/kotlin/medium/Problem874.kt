package medium

class Problem874 {
    private fun isObstacle(cur: Pair<Int, Int>, obstacles: Array<IntArray>): Boolean {
        obstacles.forEach {
            if (it[0] == cur.first && it[1] == cur.second) {
                return true
            }
        }
        return false
    }

    private fun rotate(dir: Pair<Int, Int>, deg: Int): Pair<Int, Int> {
        val leftDirs = arrayOf(Pair(0, 1), Pair(-1, 0), Pair(0, -1), Pair(1, 0))
        var t = leftDirs.indexOf(dir)
        if (deg == -2) {
            // rotate left 90 degree
            t++
            if (t == leftDirs.size) {
                t = 0
            }
        } else if (deg == -1) {
            t--
            if (t == -1) {
                t = leftDirs.size - 1
            }
        }
        return leftDirs[t]
    }

    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        var dir = Pair(0, 1)
        var cur = Pair(0, 0)
        var maxDist = 0
        commands.forEach {
            if (it < 0) {
                dir = rotate(dir, it)
            } else {
                repeat(it) {
                    val next = Pair(dir.first + cur.first, dir.second + cur.second)
                    if (!isObstacle(next, obstacles)) {
                        cur = next
                        val t = (cur.first * cur.first) + (cur.second * cur.second)
                        if (t > maxDist) {
                            maxDist = t
                        }
                    }
                }
                println("DEBUG : $cur")
            }
        }
        // final pos
        println(cur)
        return maxDist
    }
}

fun main() {
    println(Problem874().robotSim(intArrayOf(4, -1, 3), arrayOf()))
    println(Problem874().robotSim(intArrayOf(4, -1, 4, -2, 4), arrayOf(intArrayOf(2, 4))))
    println(Problem874().robotSim(intArrayOf(6, -1, -1, 6), arrayOf()))
}