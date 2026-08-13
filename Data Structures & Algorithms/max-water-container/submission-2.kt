class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1
        var size = 0
        while (left < right) {
            val a = heights[left]
            val b = heights[right]
            val dist = right - left
            size = max(size, (min(a, b) * dist))
            if (a == b) {
                left++
                right--
            } else if (a < b) {
                left++
            } else {
                right--
            }
        }
        return size
    }
}