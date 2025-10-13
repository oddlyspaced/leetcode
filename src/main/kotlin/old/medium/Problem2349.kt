package old.medium

import java.util.*

class NumberContainers() {

    private val indexToNumber = mutableMapOf<Int, Int>()
    private val numberToIndices = mutableMapOf<Int, TreeSet<Int>>()

    fun change(index: Int, number: Int) {
        // If the index already has a number, remove the old mapping
        indexToNumber[index]?.let { oldNumber ->
            numberToIndices[oldNumber]?.remove(index)
            if (numberToIndices[oldNumber]?.isEmpty() == true) {
                numberToIndices.remove(oldNumber)
            }
        }

        // Update the mapping
        indexToNumber[index] = number
        numberToIndices.computeIfAbsent(number) { TreeSet() }.add(index)
    }

    fun find(number: Int): Int {
        return numberToIndices[number]?.firstOrNull() ?: -1
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * var obj = NumberContainers()
 * obj.change(index,number)
 * var param_2 = obj.find(number)
 */

class Problem2349 {
    fun main() {
        val nc = NumberContainers()
        nc.find(10) // There is no index that is filled with number 10. Therefore, we return -1.
        nc.change(2, 10) // Your container at index 2 will be filled with number 10.
        nc.change(1, 10) // Your container at index 1 will be filled with number 10.
        nc.change(3, 10) // Your container at index 3 will be filled with number 10.
        nc.change(5, 10) // Your container at index 5 will be filled with number 10.
        nc.find(10) // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
        nc.change(
            1,
            20
        ) // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20.
        nc.find(10) // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.
    }
}