class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = hashSetOf<Int>()
    return nums.any {
        !set.add(it)
    }
    }
}
