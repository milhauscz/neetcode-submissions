class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val sortedCharsToIndices = strs.mapIndexed { index, str ->
            str.toCharArray().also { it.sort() } to index
        }
        val charsBySize = sortedCharsToIndices.groupBy {
            it.first.size
        }
        var result = mutableListOf<List<String>>()
        charsBySize.forEach { (_, charArraysToIndex) ->
            val mutableCharArraysToIndx = charArraysToIndex.toMutableList()
            while (mutableCharArraysToIndx.isNotEmpty()) {
                val iterator = mutableCharArraysToIndx.iterator()
                val base = iterator.next()
                //println("base == ${strs[base.second]}")
                iterator.remove()
                val anagrams = mutableListOf(strs[base.second])
                result.add(anagrams)
                while(iterator.hasNext()) {
                    val candidate = iterator.next()
                    //println("candidate == ${strs[candidate.second]}")
                    if (base.first.contentEquals(candidate.first)) {
                        iterator.remove()
                        anagrams.add(strs[candidate.second])
                    }
                }
            }
        }
        return result
    }
}
