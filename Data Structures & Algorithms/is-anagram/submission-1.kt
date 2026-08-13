class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val codes1 = Array(s.length) {
            s[it]
        }
        codes1.sort()
        val codes2 = Array(t.length) {
            t[it]
        }
        codes2.sort()
        return codes1.contentEquals(codes2)
    }
}
