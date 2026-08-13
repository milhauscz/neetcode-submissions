class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val endOfSequenceToLength = hashMapOf<Int,Int>()
        val startOfSequenceToLength = hashMapOf<Int,Int>()
        var longestLength = 0
        for (num in nums) {
            if (endOfSequenceToLength.containsKey(num) || startOfSequenceToLength.containsKey(num)) {
                continue
            }
            val previous = num - 1
            val next = num + 1
            val currentLengthAbove = endOfSequenceToLength.remove(previous) ?: 0
            val currentLengthBelow = startOfSequenceToLength.remove(next) ?: 0
            val length = currentLengthAbove + 1 + currentLengthBelow
            val start = num - currentLengthAbove
            startOfSequenceToLength[start] = length
            endOfSequenceToLength[next + currentLengthBelow - 1] = length
            if (length > longestLength) {
                longestLength = length
            }
        }
        return longestLength
    }
}