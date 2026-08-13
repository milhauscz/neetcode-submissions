class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numsSet = nums.toSet()
        var longest = 0
        for (num in numsSet) {
            val previous = num - 1
            if (numsSet.contains(previous)) continue
            var length = 1
            var next = num + 1
            while (numsSet.contains(next)) {
                next++
                length++
            }
            longest = max(length, longest)
        }
        return longest
    }
}
