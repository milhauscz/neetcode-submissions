class Solution {
    fun maxArea(heights: IntArray): Int {
        var size = 0
        for (i in 0..<heights.size - 1) {
            for (j in i..<heights.size) {
                val a = heights[i]
                val b = heights[j]
                val dist = j - i
                size = max(size, (min(a, b) * dist))
            }
        }
        return size
    }
}