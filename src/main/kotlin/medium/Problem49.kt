package medium

class Problem49 {
    private fun sortStr(str: String): String {
        val chars = hashMapOf<Char, Int>()
        val sorted = sortedSetOf<Char>()
        str.forEach {
            sorted.add(it)
            chars[it] = (chars[it] ?: 0) + 1
        }
        val res = StringBuilder()
        sorted.forEach { key ->
            repeat(chars[key]!!) {
                res.append(key)
            }
        }
        return res.toString()
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val data = hashMapOf<String, ArrayList<String>>()
        strs.forEach {
            val t = sortStr(it)
            if (data[t] == null) {
                data[t] = arrayListOf()
            }
            data[t]!!.add(it)
        }
        val res = arrayListOf<List<String>>()
        data.values.forEach {
            res.add(it)
        }
        return res
    }
}

fun main() {
    println(
        Problem49().groupAnagrams(
            arrayOf(
                "chi",
                "nip",
                "lab",
                "mud",
                "fan",
                "yak",
                "kid",
                "lox",
                "joy",
                "rob",
                "cad",
                "hug",
                "ken",
                "oaf",
                "pus",
                "hos",
                "ton",
                "any",
                "sac",
                "mid",
                "nip",
                "ron",
                "tux",
                "set",
                "jug",
                "axe",
                "ago",
                "sob",
                "ode",
                "dot",
                "nit",
                "pug",
                "sue",
                "new",
                "rub",
                "sup",
                "ohs",
                "ski",
                "oaf",
                "don",
                "cob",
                "kin",
                "ark",
                "gay",
                "jay",
                "bur",
                "dot",
                "eat",
                "rca",
                "wad",
                "maj",
                "luz",
                "gad",
                "dam",
                "eon",
                "ark",
                "del",
                "sin",
                "tat"
            )
        )
    )
}