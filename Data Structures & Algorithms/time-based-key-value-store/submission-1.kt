class TimeMap() {
    val keyToTimestampAndValues = mutableMapOf<String,MutableList<Pair<Int,String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        val timestampsToValues = keyToTimestampAndValues[key] ?: mutableListOf<Pair<Int, String>>().also { keyToTimestampAndValues[key] = it}
        timestampsToValues.add(timestamp to value)
    }

    fun get(key: String, timestamp: Int): String {
        val timestampsToValues = keyToTimestampAndValues[key] ?: return ""
        timestampsToValues.sortBy { it.first }
        var l = 0
        var r = timestampsToValues.size - 1
        var res: Int? = null
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (timestampsToValues[mid].first == timestamp) {
                res = mid
                break
            }
            if (timestampsToValues[mid].first < timestamp) {
                res = mid
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return res?.let { timestampsToValues[it].second } ?: ""
    }
}