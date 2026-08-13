class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var totalProduct: Long = 1
        var totalProductWithoutZero: Long = 1
        var foundZero = false
        nums.forEach {
            totalProduct *= it
            if (it == 0) {
                if (foundZero) {
                    return IntArray(nums.size) { 0 }
                } else {
                    foundZero = true
                }
            } else {
                totalProductWithoutZero *= it
            }
        }
        val result = nums.clone()
        for (i in nums.indices) {
            val num = nums[i]
            result[i] = if (num == 0) {
                totalProductWithoutZero.toInt()
            } else {
                (totalProduct / nums[i]).toInt()
            }
        }
        return result
    }
}