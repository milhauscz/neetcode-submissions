class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var end = 0
        val uniqueChars = mutableSetOf<Char>()
        var maxLength = 0
        while (end < s.length) {
            val char = s[end]
//            println("End is $end, checking $char, uniqueChars state is |${uniqueChars.joinToString(separator = "") { it.toString() }}|")
            if (!uniqueChars.add(char)) {
//                println("Duplicate")
                for (i in start..end) {
                    val removedChar = s[i]
                    if (removedChar == char) {
                        start = i + 1
//                        println("Moving start to $start")
                        break
                    }
                    uniqueChars.remove(removedChar)
                }
            }
//            println("uniqueChars state is |${uniqueChars.joinToString(separator = "") { it.toString() }}|")
            maxLength = max(maxLength, uniqueChars.size)
//            println("Max length set to $maxLength")
            end++
//            println("End moved to $end")
//            println("-----------------")
        }
        return maxLength
    }
}
