class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var left = 0
        var maxLength = 0
        var maxCount = 0
        var frequencies = IntArray(26)
        for (right in s.indices) {
            val char = s[right]
            frequencies[char - 'A']++
            val frequency = frequencies[char - 'A']
            maxCount = max(maxCount, frequency)
            val length = right - left + 1
            if (length - maxCount <= k) {
                maxLength = max(maxLength, length)
            } else {
                frequencies[s[left] - 'A']--
                left++
            }
        }
        return maxLength
    }
}
