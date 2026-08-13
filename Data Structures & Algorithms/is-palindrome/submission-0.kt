class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (!isAlphaNumeric(s[left]) || !isAlphaNumeric(s[right])) {
                while (left in s.indices && !isAlphaNumeric(s[left])) {
                    left++
                    println("Move left to $left")
                }
                while (right in s.indices && !isAlphaNumeric(s[right])) {
                    right--
                    println("Move right to $right")
                }
                continue
            }
            println("Comparing ${s[left]} and ${s[right]}")
            if (s[left].lowercaseChar() != s[right].lowercaseChar()) return false
            left++
            right--
        }
        return true
    }

    fun isAlphaNumeric(char: Char): Boolean {
        return char.lowercaseChar() - 'a' in 0..<26 || char - '0' in 0..<10
    }
}