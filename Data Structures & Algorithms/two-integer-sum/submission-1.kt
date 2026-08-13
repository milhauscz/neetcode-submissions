class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToIndices = hashMapOf<Int,ArrayList<Int>>()
        nums.forEachIndexed { index, num ->
            numToIndices.getOrPut(num) {
                arrayListOf()
            }.add(index)
        }
        nums.forEachIndexed { index1, num ->
            numToIndices[num]?.removeFirst()
            val looking = target - num
            val index2 = numToIndices[looking]?.firstOrNull()
            if (index2 != null) {
                return intArrayOf(index1, index2)
            }
        }
        throw IllegalStateException()
    }
}
