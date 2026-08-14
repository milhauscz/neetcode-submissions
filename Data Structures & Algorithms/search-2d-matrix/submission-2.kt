class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        return search(searchRow(matrix, target) ?: return false, target) != -1
    }

    fun searchRow(rows: Array<IntArray>, target: Int): IntArray? {
        var left = 0
        var right = rows.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (rows[mid].first() <= target && rows[mid].last() >= target) {
                return rows[mid]
            } else if (rows[mid].first() > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return null
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
