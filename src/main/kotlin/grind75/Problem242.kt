package grind75

/**
 * Created by Hardik Srivastava on 15/10/25
 */
class Problem242 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val m = hashMapOf<Char, Int>()
        s.forEach {
            m[it] = m.getOrDefault(it, 0) + 1
        }
        t.forEach {
            m[it] = m.getOrDefault(it, 0) - 1
        }
        m.values.forEach {
            if (it != 0)
                return false
        }
        return true
    }
}