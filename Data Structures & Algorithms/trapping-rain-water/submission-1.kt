class Solution {
    fun trap(height: IntArray): Int {
        val maxLeft = IntArray(height.size)
        val maxRight = IntArray(height.size)
        var max = height[0]
        for (i in 1..<height.size) {
            val cur = height[i]
            maxLeft[i] = max
//            println("maxLeft for $i = $max")
            max = max(max, cur)
//            println("setting max to $max")
        }
        max = height[height.size - 1]
        for (i in height.size - 2 downTo 0) {
            val cur = height[i]
            maxRight[i] = max
            max = max(max, cur)
        }
        var volume = 0
        for (i in 0..<height.size) {
            val add = max(min(maxLeft[i], maxRight[i]) - height[i], 0)
//            println("Column $i, maxLeft is ${maxLeft[i]}, maxRight is ${maxRight[i]}, adding $add")
            volume += add
        }
        return volume
    }
}