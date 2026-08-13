class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val s1Frequencies = IntArray(26)
        for(char in s1) {
            s1Frequencies[char - 'a']++
        }

        val windowFrequencies = IntArray(26)
        out@for(i in s2.indices) {
            windowFrequencies[s2[i] - 'a']++
            if (i >= s1.length) {
                windowFrequencies[s2[i - s1.length] - 'a']--
            }
            if (s1Frequencies.contentEquals(windowFrequencies)) return true
        }
        return false
    }
}
