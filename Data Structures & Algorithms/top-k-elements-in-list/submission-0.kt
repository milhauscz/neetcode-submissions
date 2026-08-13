class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val groupedNumbers = nums.groupBy { it }.values.sortedBy { -it.size }
        return IntArray(k) {
            groupedNumbers[it].first()
        }
    }
}
