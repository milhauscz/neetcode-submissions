class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableSetOf<List<Int>>()
        for (i in 0..<nums.size - 2) {
            for (j in i + 1..<nums.size - 1) {
                for (k in j + 1..<nums.size) {
                    var x = nums[i]
                    var y = nums[j]
                    var z = nums[k]
                    if (x + y + z == 0) {
                        if (x < y) {
                            val temp = x
                            x = y
                            y = temp
                        }
                        if (y < z) {
                            val temp = y
                            y = z
                            z = temp
                        }
                        if (x < y) {
                            val temp = x
                            x = y
                            y = temp
                        }
                        result.add(listOf(x, y, z))
                    }
                }
            }
        }
        return result.toList()
    }
}