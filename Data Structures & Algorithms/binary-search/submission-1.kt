class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var i = 0
        while (true) {
            val mid = (left + right) / 2
            if (i++ > 100) throw IllegalStateException()
            if (nums[mid] == target) return mid
            else if (right - left == 1) {
                left = right
            } else if (right - left == 0) {
                return -1
            }
            else if (nums[mid] > target) {
                right = mid
            } else {
                left = mid
            }
        }
        return -1
    }
}
