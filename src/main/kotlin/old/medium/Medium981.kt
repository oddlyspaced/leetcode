package old.medium

import java.util.*
import kotlin.collections.HashMap

class TimeMap() {private val map = HashMap<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        val tree = map.getOrPut(key) { TreeMap() }
        tree[timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        val tree = map[key] ?: return ""

        val entry = tree.floorEntry(timestamp) ?: return ""
        return entry.value
    }
}

fun main() {
    TimeMap().let {
        it.set("love", "high", 10)
        it.set("love", "low", 20)
        println(it.get("love", 5))
        println(it.get("love", 10))
        println(it.get("love", 15))
        println(it.get("love", 20))
        println(it.get("love", 25))
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * var obj = TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */