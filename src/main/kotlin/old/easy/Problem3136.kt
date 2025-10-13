package old.easy

class Problem3136 {
    fun isValid(word: String): Boolean {
        if (word.length < 3) {
            return false
        }
        val vowels = "aeiou"
        var hasVowel = false
        var hasConst = false
        for (c in word) {
            if (!c.isLetterOrDigit()) {
                return false
            }
            if (c.isLetter()) {
                if (vowels.contains(c.lowercaseChar())) {
                    hasVowel = true
                } else {
                    hasConst = true
                }
            }
        }
        return hasVowel && hasConst
    }
}