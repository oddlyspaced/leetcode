package hard

import java.util.*
import kotlin.collections.HashMap

// Solution by mobdev :
// https://leetcode.com/problems/all-oone-data-structure/solutions/5847651/kotlin-beats-72-484-ms-hashmap-treeset-solution/?envType=daily-question&envId=2024-09-29
class Problem432() {

    private var order: Int = 0
    private val strings = HashMap<String, Counter>()
    private val sortedStrings = TreeSet<Counter>()

    fun inc(key: String) {
        val entry = strings[key]
        if (entry != null) {
            sortedStrings.remove(entry)
            entry.count++
            sortedStrings.add(entry)
        } else {
            val newEntry = Counter(key, order++, 1)
            strings[key] = newEntry
            sortedStrings.add(newEntry)
        }
    }

    fun dec(key: String) {
        val entry = strings[key]
        if (entry != null) {
            sortedStrings.remove(entry)
            entry.count--
            if (entry.count > 0) {
                sortedStrings.add(entry)
            }
        }
    }

    fun getMaxKey(): String = if (sortedStrings.size > 0) sortedStrings.last().key else ""

    fun getMinKey(): String = if (sortedStrings.size > 0) sortedStrings.first().key else ""
}

class Counter(val key: String, val order: Int, var count: Int) : Comparable<Counter> {
    override fun compareTo(b: Counter): Int {
        val diff = count - b.count
        return if (diff == 0) order - b.order else diff
    }
}