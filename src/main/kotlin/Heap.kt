class Heap {

    private fun displayHeap(values: IntArray) {
        var count = 1
        var index = 0

        while (index < values.size) {
            repeat((values.size / 2) - index) {
                print(" ")
            }
            for (i in 0..<count) {
                print("${values[index++]} ")
                if (index == values.size) {
                    break
                }
            }
            println()
            count *= 2
        }
    }

    fun createHeap(values: IntArray) {
        val heapValues = IntArray(values.size)
        var heapIndex = 0

        for (value in values) {
            // first put it at end of heap values array to ensure complete binary tree
            heapValues[heapIndex] = value
            // now check if it's a heap or not
            var tempHeapIndex = heapIndex
            while (tempHeapIndex > 0) {
                val parentTempHeapIndex = tempHeapIndex / 2
                // parent bigger
                if (heapValues[parentTempHeapIndex] > heapValues[tempHeapIndex]) {
                    val t = heapValues[parentTempHeapIndex]
                    heapValues[parentTempHeapIndex] = heapValues[tempHeapIndex]
                    heapValues[tempHeapIndex] = t
                }
                tempHeapIndex = parentTempHeapIndex
            }
            heapIndex++
        }

        displayHeap(heapValues)
        println(heapValues.joinToString(","))
    }

    fun heapSort(values: IntArray) {
        val heapValues = IntArray(values.size)

        for ((heapIndex, value) in values.withIndex()) {
            // first put it at end of heap values array to ensure complete binary tree
            heapValues[heapIndex] = value
            // now check if it's a heap or not
            var tempHeapIndex = heapIndex
            while (tempHeapIndex > 0) {
                val parentTempHeapIndex = tempHeapIndex / 2
                // parent smaller
                if (heapValues[parentTempHeapIndex] < heapValues[tempHeapIndex]) {
                    val t = heapValues[parentTempHeapIndex]
                    heapValues[parentTempHeapIndex] = heapValues[tempHeapIndex]
                    heapValues[tempHeapIndex] = t
                }
                tempHeapIndex = parentTempHeapIndex
            }
        }
        displayHeap(heapValues)
        println(heapValues.joinToString(","))

        // remove values one by one
        var heapSize = heapValues.size
        repeat(2) {
            val removed = heapValues[0]
            println("REMOVED : $removed")
            // put last value to first
            heapValues[0] = heapValues[heapSize - 1]
            heapSize -= 1
            var heapIndex = 0
            while (heapIndex < heapSize) {
                val leftChildIndex = if (heapIndex == 0) 1 else heapIndex * 2
                val rightChildIndex = if (heapIndex == 0) 2 else (heapIndex * 2) + 1
                if (leftChildIndex >= heapSize || rightChildIndex >= heapSize) {
                    break
                }
                val leftChild = heapValues[leftChildIndex]
                val rightChild = heapValues[rightChildIndex]

                if (leftChild > rightChild) {
                    // swap with left
                    val t = heapValues[heapIndex]
                    heapValues[heapIndex] = heapValues[leftChildIndex]
                    heapValues[leftChildIndex] = t
                    heapIndex = leftChildIndex
                } else {
                    val t = heapValues[heapIndex]
                    heapValues[heapIndex] = heapValues[rightChildIndex]
                    heapValues[rightChildIndex] = t
                    heapIndex = rightChildIndex
                }
            }
        }

        println("---")
        displayHeap(heapValues.sliceArray(0..<heapSize))
        println(heapValues.sliceArray(0..<heapSize).joinToString(","))
    }
}

fun main() {
    Heap().heapSort(intArrayOf(5, 4, 0, 1, 9, 10, 12))
}