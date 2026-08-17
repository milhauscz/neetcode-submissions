class Solution {
    fun findDuplicate(nums: IntArray): Int {
        nums.sort()
        var prev = -1
        for (num in nums) {
            if (num == prev) return num
            prev = num
        }
        return -1
    }
}
