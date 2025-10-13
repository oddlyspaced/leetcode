package old.medium

import kotlin.math.min

class Problem1233 {
    private fun checkSubFolder(folder1: String, folder2: String): Boolean {
        val f1 = folder1.split("/")
        val f2 = folder2.split("/")

        val minlen = min(f1.size, f2.size)
        for (i in 0..<minlen) {
            if (f1[i] != f2[i]) {
                return false
            }
        }
        return true
    }

    fun removeSubfolders(folder: Array<String>): List<String> {
        var i = 0
        var j = 1
        val folders = folder.sorted().toMutableList()
        while (i < folders.size) {
            if (j == folders.size) {
                break
            }
            if (checkSubFolder(folders[i], folders[j])) {
                folders.removeAt(j)
            } else {
                i++
                j = i + 1
            }
        }
        return folders
    }
}

fun main() {
    println(Problem1233().removeSubfolders(arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")).joinToString(","))
    println(Problem1233().removeSubfolders(arrayOf("/a", "/a/b/c", "/a/b/d")).joinToString(","))
    println(Problem1233().removeSubfolders(arrayOf("/a/b/c", "/a/b/ca", "/a/b/d")).joinToString(","))
    println(Problem1233().removeSubfolders(arrayOf("/ah/al/am", "/ah/al")).joinToString(","))
}