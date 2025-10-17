package grind75

/**
 * Created by Hardik Srivastava on 15/10/25
 */
class Problem733 {

    private val visited = hashSetOf<Pair<Int, Int>>()

    private fun fill(image: Array<IntArray>, r: Int, c: Int, color: Int, target: Int) {
        if (r < 0 || r >= image.size) {
            return
        }
        if (c < 0 || c >= image[0].size) {
            return
        }

        if (visited.contains(Pair(r, c))) {
            return
        }
        visited.add(Pair(r, c))
        if (image[r][c] == target) {
            image[r][c] = color
        }
        else {
            return
        }
        fill(image, r + 1, c, color, target)
        fill(image, r - 1, c, color, target)
        fill(image, r, c + 1, color, target)
        fill(image, r, c - 1, color, target)
//        fill(image, r - 1, c + 1, color, target)
//        fill(image, r + 1, c - 1, color, target)
//        fill(image, r - 1, c - 1, color, target)
    }

    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        fill(image, sr, sc, color, image[sr][sc])
        return image
    }
}

fun main() {
    val res = Problem733().floodFill(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1),
        ), 1, 1, 2
    )

    res.forEach {
        println(it.joinToString())
    }
}