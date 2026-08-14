class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (row in matrix) {
            if (row.first() <= target && row.last() >= target) {
                val res = search(row, target)
                if (res != -1) return true
            }
        }
        return false
    }

    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1
    }
}
